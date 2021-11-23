package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.exception.DataBaseErrorException;
import by.itacademy.mikhalevich.icourse.jdbc.EntityManagerHelper;
import by.itacademy.mikhalevich.icourse.model.AbstractEntity;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public abstract class AbstractRepositoryJpaImpl<T extends AbstractEntity<Integer>> implements Repository<T> {

    protected final EntityManagerHelper helper = EntityManagerHelper.getInstance();

//    Придется передавать тип извне
//    private final Class<T> clazz;

    protected abstract TypedQuery<T> findAllQuery();

    //    Этот метод вызывается из наследуемого класса паттерн Template
    @Override
    public Map<Integer, T> findAll() {
        List<T> entities = new ArrayList<>();
        EntityManager em = null;
        try {
            em = helper.getEntityManager();
            em.getTransaction().begin();

            entities = findAllQuery().getResultList();

            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            safeRollback(em, e);
        } finally {
            quietCloseEntityManager(em);
        }

        Map<Integer, T> result = entities.stream()
            .collect(Collectors.toMap(T::getId, Function.identity()));

        return result;
    }

    @Override
    public Optional<T> find(int id) {
        EntityManager em = helper.getEntityManager();
        em.getTransaction().begin();

        T entity = em.find(getType(), id);

        em.getTransaction().commit();
        em.close();
        return Optional.ofNullable(entity);
    }

    @Override
    public T save(T entity, int parameterIndex) {
        EntityManager em = helper.getEntityManager();
        em.getTransaction().begin();
        if (entity.getId() == null) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    @Override
    public Optional<T> remove(T entity) {
        EntityManager em = helper.getEntityManager();
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        em.close();
        return Optional.ofNullable(entity);
    }

    private Class<T> getType() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        return  (Class) type.getActualTypeArguments()[0];
    }

    private void safeRollback(EntityManager em, Exception e) {
        log.error(e.getMessage(), e);
        if (em != null) {
            em.getTransaction().rollback();
        }
        throw new DataBaseErrorException(e);
    }

    private void quietCloseEntityManager(EntityManager em) {
        if (em != null) {
            try {
                em.close();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                //doNothing
            }
        }
    }
}

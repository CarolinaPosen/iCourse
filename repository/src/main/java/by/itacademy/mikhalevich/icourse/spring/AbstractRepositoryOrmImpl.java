package by.itacademy.mikhalevich.icourse.spring;

import by.itacademy.mikhalevich.icourse.GroupRepository;
import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.model.AbstractEntity;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


@Slf4j
@org.springframework.stereotype.Repository
@RequiredArgsConstructor
public abstract class AbstractRepositoryOrmImpl<T extends AbstractEntity> implements Repository<T> {

    protected Class<T> clazz;
    private EntityManagerFactory emf;
    private final ThreadLocal<EntityManager> emThreadLocal = new ThreadLocal<>();

    protected abstract TypedQuery<T> findByNameQuery(String name);

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Map<Integer, T> findAll() {
        begin();
        List<T> resultList = getEntityManager().createQuery("from " + clazz.getName(), clazz).getResultList();
        commit();
        Map<Integer, T> result = resultList.stream().collect(Collectors.toMap(T::getId, Function.identity()));
        return result;
    }

    @Override
    public Optional<T> find(int id) {
        begin();
        Optional<T> optionalEntity = Optional.ofNullable(getEntityManager().find(clazz, id));
        commit();
        return optionalEntity;
    }

    @Override
    public Optional<T> findByName(String name) {
        T entity = null;
        begin();
        entity = findByNameQuery(name).getSingleResult();
        commit();
        return Optional.ofNullable(entity);
    }

    @Override
    public T save(T entity) {
        begin();
        if (entity.getId() == null) {
            getEntityManager().persist(entity);
        } else {
            getEntityManager().merge(entity);
        }
        commit();
        return entity;
    }

    @Override
    public Optional<T> remove(T entity) {
        begin();
        Optional<T> foundEntityOptional = Optional.ofNullable(getEntityManager().find(clazz, entity.getId()));
        if (foundEntityOptional.isPresent()) {
            getEntityManager().remove(entity);
            commit();
            return foundEntityOptional;
        }
        commit();
        return Optional.empty();
    }

    public EntityManager getEntityManager() {
        if (emThreadLocal.get() == null) {
            emThreadLocal.set(emf.createEntityManager());
        }
        return emThreadLocal.get();
    }

    public void begin() {
        getEntityManager().getTransaction().begin();
    }

    public void commit() {
        getEntityManager().getTransaction().commit();
    }

    public void rollBack() {
        getEntityManager().getTransaction().rollback();
    }

}

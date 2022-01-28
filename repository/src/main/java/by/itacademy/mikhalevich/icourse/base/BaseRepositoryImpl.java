package by.itacademy.mikhalevich.icourse.base;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.model.AbstractEntity;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


@Slf4j
@org.springframework.stereotype.Repository("baseRepositoryImpl")
public class BaseRepositoryImpl<T extends AbstractEntity> implements Repository<T> {

    protected Class<T> clazz;

    @PersistenceContext
    @Getter
    protected EntityManager em;

    @Override
    public Map<Integer, T> findAll() {
        List<T> resultList;
        resultList = em.createQuery("from " + clazz.getName(), clazz).getResultList();
        Map<Integer, T> result = resultList.stream().collect(Collectors.toMap(T::getId, Function.identity()));
        return result;
    }

    @Override
    public Optional<T> find(Integer id) {
        return Optional.ofNullable(em.find(clazz, id));
    }

    @Override
    public Optional<T> findByName(String name) {
        Query query = em.createQuery("Select c " + clazz.getName() +" c WHERE c.name like :name ");
        query.setParameter("name", name);
        return Optional.ofNullable((T) query.getSingleResult());
    }

    @Override
    public T save(T entity) {
        if (entity.getId() == null) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        return entity;
    }

    @Override
    public Optional<T> remove(Integer id) {
        T entity = null;
        Optional<T> foundEntityOptional = Optional.ofNullable(em.find(clazz, id));
        if (foundEntityOptional.isPresent()) {
            entity = em.find(clazz, id);
            em.remove(entity);
            return foundEntityOptional;
        }
        return Optional.empty();
    }
}

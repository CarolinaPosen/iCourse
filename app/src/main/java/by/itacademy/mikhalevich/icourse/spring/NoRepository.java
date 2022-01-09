package by.itacademy.mikhalevich.icourse.spring;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
public interface NoRepository<T> {
    Map<Integer, T> findAll();
    Optional<T> find(int id);
    Optional<T> findByName(String name);
    T save(T entity);
    Optional<T> remove(T entity);
}

//    Map<Integer, T> result = entities.stream()
//            .collect(Collectors.toMap(T::getId, Function.identity()));
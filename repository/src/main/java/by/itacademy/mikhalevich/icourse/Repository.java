package by.itacademy.mikhalevich.icourse;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Repository<T> {
    Map<Integer, T> findAll();
    Optional<T> find(Integer id);
    Optional<T> findByName(String name);
    T save(T entity);
    Optional<T> remove(Integer id);
}

//    Map<Integer, T> result = entities.stream()
//            .collect(Collectors.toMap(T::getId, Function.identity()));
package by.itacademy.mikhalevich.icourse;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Repository<T> {
    Map<Integer, T> findAll();
    Optional<T> find(int id);
    T save(T entity, int parameterIndex);
    Optional<T> remove(T entity);
}

//    Map<Integer, T> result = entities.stream()
//            .collect(Collectors.toMap(T::getId, Function.identity()));
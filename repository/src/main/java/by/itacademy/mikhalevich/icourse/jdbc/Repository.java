package by.itacademy.mikhalevich.icourse.jdbc;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Repository<T> {
    Map<Integer, T> findAll();
    Optional<T> find(int id);
    T save(T entity);
    Optional<T> remove(T entity);
}

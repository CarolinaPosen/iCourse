package by.itacademy.mikhalevich.icourse;

import by.itacademy.mikhalevich.icourse.model.Group;

import java.util.Map;
import java.util.Optional;

public interface Service<T> {
    Map<Integer, T> read();
    Optional<T> update(T t);
    Optional<T> create(T t);
    Optional<T> delete(T t);
    Optional<T> getGroupById (Integer id);
}

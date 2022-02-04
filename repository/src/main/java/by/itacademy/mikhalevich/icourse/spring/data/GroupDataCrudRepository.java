package by.itacademy.mikhalevich.icourse.spring.data;

import by.itacademy.mikhalevich.icourse.model.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupDataCrudRepository extends CrudRepository<Group, Integer> {
    List<Group> findAll();

}

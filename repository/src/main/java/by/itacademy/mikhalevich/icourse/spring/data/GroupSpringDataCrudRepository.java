package by.itacademy.mikhalevich.icourse.spring.data;

import by.itacademy.mikhalevich.icourse.model.Group;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GroupSpringDataCrudRepository extends CrudRepository<Group, Integer> {
    List<Group> findAll();
    Optional<Group> findById(ID var1);
    void deleteById(ID var2);
    Group save(Group group);
    Optional<Group> findByTitleStartingWith(String str);

}

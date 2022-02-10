package by.itacademy.mikhalevich.icourse.spring.data;

import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TrainerSpringDataJpaRepository extends JpaRepository<Trainer, Integer> {
    List<Trainer> findAll();
    Optional<Trainer> findById(ID var1);
    void deleteById(ID var2);
    Trainer save (Trainer trainer);

}

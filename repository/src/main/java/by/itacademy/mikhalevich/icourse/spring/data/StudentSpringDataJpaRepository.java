package by.itacademy.mikhalevich.icourse.spring.data;

import by.itacademy.mikhalevich.icourse.model.Student;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentSpringDataJpaRepository extends JpaRepository<Student, Integer> {
    List<Student> findAll();
    Optional<Student> findById(ID var1);
    void deleteById(ID var2);
    Student save (Student student);

}

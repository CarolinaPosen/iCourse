package by.itacademy.mikhalevich.icourse.base;

import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("studentBaseRepositoryImpl")
public class StudentBaseRepositoryImpl extends BaseRepositoryImpl<Student> implements StudentBaseRepository {

    public StudentBaseRepositoryImpl() {
        super();
        clazz = Student.class;
    }

    @Override
    public Map<Integer, Student> getStudentMap() {
        em.createQuery("from Student ").getResultList();
        return null;
    }
}

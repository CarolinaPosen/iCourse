package by.itacademy.mikhalevich.icourse.spring;

import by.itacademy.mikhalevich.icourse.GroupRepository;
import by.itacademy.mikhalevich.icourse.StudentRepository;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository("studentRepositoryOrmImpl")
public class StudentRepositoryOrmImpl extends AbstractRepositoryOrmImpl<Student> implements StudentRepository {

    public StudentRepositoryOrmImpl(){
        clazz = Student.class;
    }

    @Override
    protected TypedQuery<Student> findByNameQuery(String name) {
        return null;
    }
}

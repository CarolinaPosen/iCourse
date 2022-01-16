package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.StudentRepository;
import by.itacademy.mikhalevich.icourse.model.Student;

import javax.persistence.TypedQuery;

public class StudentRepositoryJpaImpl extends AbstractRepositoryJpaImpl<Student> implements StudentRepository {
    private static volatile StudentRepositoryJpaImpl instance;

    private StudentRepositoryJpaImpl() {
    }

    public static StudentRepositoryJpaImpl getInstance() {
        if (instance == null) {
            synchronized (StudentRepositoryJpaImpl.class) {
                if (instance == null) {
                    instance = new StudentRepositoryJpaImpl();
                }
            }
        }
        return instance;
    }

    @Override
    protected TypedQuery<Student> findAllQuery() {
        return helper.getEntityManager().createQuery("from Student", Student.class);
    }

    @Override
    protected TypedQuery<Student> findByNameQuery(String name) {
        TypedQuery<Student> query = helper.getEntityManager().createQuery("from Student s where s.name = :name", Student.class);
        query.setParameter("name", name);
        return query;
    }
}

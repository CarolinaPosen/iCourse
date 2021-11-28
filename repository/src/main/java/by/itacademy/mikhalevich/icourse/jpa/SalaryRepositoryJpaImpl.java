package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.SalaryRepository;
import by.itacademy.mikhalevich.icourse.jdbc.TeacherRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.model.AbstractEntity;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Salary;

import javax.persistence.TypedQuery;

public class SalaryRepositoryJpaImpl extends AbstractRepositoryJpaImpl<Salary> implements SalaryRepository {

    private SalaryRepositoryJpaImpl() {
    }

    private static volatile SalaryRepositoryJpaImpl instance;

    public static SalaryRepositoryJpaImpl getInstance() {
        if (instance == null) {
            synchronized (SalaryRepositoryJpaImpl.class) {
                if (instance == null) {
                    instance = new SalaryRepositoryJpaImpl();
                }
            }
        }
        return instance;
    }

    @Override
    protected TypedQuery<Salary> findAllQuery() {
        return helper.getEntityManager().createQuery("from Salary", Salary.class);
    }

    @Override
    protected TypedQuery<Salary> findByNameQuery(String name) {
        TypedQuery<Salary> query = helper.getEntityManager().createQuery("from Salary s where s.salary = :name", Salary.class);
        query.setParameter("name", name);
        return query;
    }

}

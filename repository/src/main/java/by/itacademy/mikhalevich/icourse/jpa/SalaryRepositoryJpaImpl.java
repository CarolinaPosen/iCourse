package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.jdbc.TeacherRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.model.AbstractEntity;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Salary;

import javax.persistence.TypedQuery;

public class SalaryRepositoryJpaImpl extends AbstractRepositoryJpaImpl<Salary> {

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

}
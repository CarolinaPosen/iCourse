package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.jdbc.TeacherRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.model.Trainer;

import javax.persistence.TypedQuery;

public class TrainerRepositoryJpaImpl extends AbstractRepositoryJpaImpl<Trainer> {

    private static volatile TrainerRepositoryJpaImpl instance;

    private TrainerRepositoryJpaImpl() {
    }

    public static TrainerRepositoryJpaImpl getInstance() {
        if (instance == null) {
            synchronized (TeacherRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new TrainerRepositoryJpaImpl();
                }
            }
        }
        return instance;
    }

    @Override
    protected TypedQuery<Trainer> findAllQuery() {
       return helper.getEntityManager().createQuery("from Trainer", Trainer.class);
    }
}

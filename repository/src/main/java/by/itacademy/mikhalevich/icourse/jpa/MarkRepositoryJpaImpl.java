package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.model.Mark;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Trainer;

import javax.persistence.TypedQuery;

public class MarkRepositoryJpaImpl extends AbstractRepositoryJpaImpl<Mark> {
    private MarkRepositoryJpaImpl() {
    }

    private static volatile MarkRepositoryJpaImpl instance;

    public static MarkRepositoryJpaImpl getInstance() {
        if (instance == null) {
            synchronized (MarkRepositoryJpaImpl.class) {
                if (instance == null) {
                    instance = new MarkRepositoryJpaImpl();
                }
            }
        }
        return instance;
    }


    //"from Role" для получения этого значения использовать Class<?> clazz, clazz.getSimpleName());
    @Override
    protected TypedQuery<Mark> findAllQuery() {
        return helper.getEntityManager().createQuery("from Mark", Mark.class);
    }

    @Override
    protected TypedQuery<Mark> findByNameQuery(String name) {
        TypedQuery<Mark> query = helper.getEntityManager().createQuery("from Mark m where m.mark = :name", Mark.class);
        query.setParameter("name", name);
        return query;
    }
}

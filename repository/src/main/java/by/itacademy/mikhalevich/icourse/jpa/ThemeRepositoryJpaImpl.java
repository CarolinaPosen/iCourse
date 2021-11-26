package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.model.Theme;

import javax.persistence.TypedQuery;

public class ThemeRepositoryJpaImpl extends AbstractRepositoryJpaImpl<Theme> {
    private ThemeRepositoryJpaImpl() {
    }

    private static volatile ThemeRepositoryJpaImpl instance;

    public static ThemeRepositoryJpaImpl getInstance() {
        if (instance == null) {
            synchronized (ThemeRepositoryJpaImpl.class) {
                if (instance == null) {
                    instance = new ThemeRepositoryJpaImpl();
                }
            }
        }
        return instance;
    }


    //"from Role" для получения этого значения использовать Class<?> clazz, clazz.getSimpleName());
    @Override
    protected TypedQuery<Theme> findAllQuery() {
        return helper.getEntityManager().createQuery("from Theme", Theme.class);
    }

    @Override
    protected TypedQuery<Theme> findByNameQuery(String name) {
        TypedQuery<Theme> query = helper.getEntityManager().createQuery("from Theme t where t.title = :name", Theme.class);
        query.setParameter("name", name);
        return query;
    }
}

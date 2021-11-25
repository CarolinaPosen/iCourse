package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.jdbc.TeacherRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.model.Role;

import javax.persistence.TypedQuery;

public class RoleRepositoryJpaImpl extends AbstractRepositoryJpaImpl<Role> {
    private RoleRepositoryJpaImpl() {
    }

    private static volatile RoleRepositoryJpaImpl instance;

    public static RoleRepositoryJpaImpl getInstance() {
        if (instance == null) {
            synchronized (TeacherRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new RoleRepositoryJpaImpl();
                }
            }
        }
        return instance;
    }


    //"from Role" для получения этого значения использовать Class<?> clazz, clazz.getSimpleName());
    @Override
    protected TypedQuery<Role> findAllQuery() {
        return helper.getEntityManager().createQuery("from Role", Role.class);
    }
}

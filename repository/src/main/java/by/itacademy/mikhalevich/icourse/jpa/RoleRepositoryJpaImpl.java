package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.RoleRepository;
import by.itacademy.mikhalevich.icourse.jdbc.TeacherRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.model.auth.Role;

import javax.persistence.TypedQuery;

public class RoleRepositoryJpaImpl extends AbstractRepositoryJpaImpl<Role> implements RoleRepository {

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

    @Override
    protected TypedQuery<Role> findByNameQuery(String name) {
            TypedQuery<Role> query = helper.getEntityManager().createQuery("from Role r where r.name = :name", Role.class);
            query.setParameter("name", name);
            return query;
    }

}

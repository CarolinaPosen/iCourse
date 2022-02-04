package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.AuthorityRepository;
import by.itacademy.mikhalevich.icourse.RoleRepository;
import by.itacademy.mikhalevich.icourse.jdbc.TeacherRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.model.auth.Authority;
import by.itacademy.mikhalevich.icourse.model.auth.Role;

import javax.persistence.TypedQuery;

public class AuthorityRepositoryJpaImpl extends AbstractRepositoryJpaImpl<Authority> implements AuthorityRepository {

    private AuthorityRepositoryJpaImpl() {
    }

    private static volatile AuthorityRepositoryJpaImpl instance;

    public static AuthorityRepositoryJpaImpl getInstance() {
        if (instance == null) {
            synchronized (AuthorityRepositoryJpaImpl.class) {
                if (instance == null) {
                    instance = new AuthorityRepositoryJpaImpl();
                }
            }
        }
        return instance;
    }

    //"from Role" для получения этого значения использовать Class<?> clazz, clazz.getSimpleName());
    @Override
protected TypedQuery<Authority> findAllQuery() {
    return helper.getEntityManager().createQuery("from Authority", Authority.class);
}

    @Override
    protected TypedQuery<Authority> findByNameQuery(String name) {
            TypedQuery<Authority> query = helper.getEntityManager().createQuery("from Authority r where r.name = :name", Authority.class);
            query.setParameter("name", name);
            return query;
    }

}

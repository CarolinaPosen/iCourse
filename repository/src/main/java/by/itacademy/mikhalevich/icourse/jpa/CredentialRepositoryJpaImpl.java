package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.CredentialRepository;
import by.itacademy.mikhalevich.icourse.RoleRepository;
import by.itacademy.mikhalevich.icourse.jdbc.TeacherRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.model.auth.Credential;
import by.itacademy.mikhalevich.icourse.model.auth.Role;

import javax.persistence.TypedQuery;

public class CredentialRepositoryJpaImpl extends AbstractRepositoryJpaImpl<Credential> implements CredentialRepository {

    private CredentialRepositoryJpaImpl() {
    }

    private static volatile CredentialRepositoryJpaImpl instance;

    public static CredentialRepositoryJpaImpl getInstance() {
        if (instance == null) {
            synchronized (TeacherRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new CredentialRepositoryJpaImpl();
                }
            }
        }
        return instance;
    }


    //"from Role" для получения этого значения использовать Class<?> clazz, clazz.getSimpleName());
    @Override
protected TypedQuery<Credential> findAllQuery() {
    return helper.getEntityManager().createQuery("from Credential", Credential.class);
}

    @Override
    protected TypedQuery<Credential> findByNameQuery(String name) {
            TypedQuery<Credential> query = helper.getEntityManager().createQuery("from Credential r where r.username = :name", Credential.class);
            query.setParameter("name", name);
            return query;
    }

}

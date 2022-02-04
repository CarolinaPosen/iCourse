package by.itacademy.mikhalevich.icourse.spring;

import by.itacademy.mikhalevich.icourse.RoleRepository;
import by.itacademy.mikhalevich.icourse.model.ExRole;
import by.itacademy.mikhalevich.icourse.model.auth.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository("roleRepositoryOrmImpl")
public class RoleRepositoryOrmImpl extends AbstractRepositoryOrmImpl<Role> implements RoleRepository {

    public RoleRepositoryOrmImpl() {
        clazz = Role.class;
    }

    @Override
    protected TypedQuery<Role> findByNameQuery(String name) {
        TypedQuery<Role> query = getEntityManager().createQuery("from Role r where r.name = :name", Role.class);
        query.setParameter("name", name);
        return query;
    }
}
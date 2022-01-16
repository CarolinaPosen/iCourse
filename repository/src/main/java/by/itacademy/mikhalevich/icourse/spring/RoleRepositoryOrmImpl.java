package by.itacademy.mikhalevich.icourse.spring;

import by.itacademy.mikhalevich.icourse.RoleRepository;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository("roleRepositoryOrmImpl")
public class RoleRepositoryOrmImpl extends AbstractRepositoryOrmImpl<Role> implements RoleRepository {

    public RoleRepositoryOrmImpl() {
        clazz = Role.class;
    }

    @Override
    protected TypedQuery<Role> findByNameQuery(String name) {
        TypedQuery<Role> query = getEntityManager().createQuery("from Role r where r.title = :name", Role.class);
        query.setParameter("name", name);
        return query;
    }
}
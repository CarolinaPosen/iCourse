package by.itacademy.mikhalevich.icourse.spring;

import by.itacademy.mikhalevich.icourse.model.Group;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.Map;
import java.util.Optional;

//@Component("abstractRepositoryOrm")
public class NoGroupRepositoryOrmImpl extends NoAbstractRepositoryOrmImpl<Group> implements NoGroupRepository {

    @Override
    protected TypedQuery<Group> findAllQuery() {
        return helper.getEntityManager().createQuery("from Group", Group.class);
    }

    @Override
    protected TypedQuery<Group> findByNameQuery(String name) {
        TypedQuery<Group> query = helper.getEntityManager().createQuery("from Group g where g.title = :name", Group.class);
        query.setParameter("name", name);
        return query;
    }

}

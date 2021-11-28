package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.GroupRepository;
import by.itacademy.mikhalevich.icourse.model.Group;

import javax.persistence.TypedQuery;

public class GroupRepositoryJpaImpl extends AbstractRepositoryJpaImpl<Group> implements GroupRepository {

    private static volatile GroupRepositoryJpaImpl instance;

    private GroupRepositoryJpaImpl() {
    }

    public static GroupRepositoryJpaImpl getInstance() {
        if (instance == null) {
            synchronized (GroupRepositoryJpaImpl.class) {
                if (instance == null) {
                    instance = new GroupRepositoryJpaImpl();
                }
            }
        }
        return instance;
    }

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

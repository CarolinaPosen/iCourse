package by.itacademy.mikhalevich.icourse.jpa;

import by.itacademy.mikhalevich.icourse.model.Group;

import javax.persistence.TypedQuery;

public class GroupRepositoryJpaImpl extends AbstractRepositoryJpaImpl<Group> {

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
}

package by.itacademy.mikhalevich.icourse.base;

import by.itacademy.mikhalevich.icourse.model.Group;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("groupBaseRepositoryImpl")
public class GroupBaseRepositoryImpl extends BaseRepositoryImpl<Group> implements GroupBaseRepository {

    public GroupBaseRepositoryImpl() {
        super();
        clazz = Group.class;
    }

    @Override
    public Map<Integer, Group> getGroupMap() {
        em.createQuery("from Group").getResultList();
        return null;
    }
}

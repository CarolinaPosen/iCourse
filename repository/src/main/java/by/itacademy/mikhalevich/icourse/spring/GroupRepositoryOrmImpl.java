package by.itacademy.mikhalevich.icourse.spring;

import by.itacademy.mikhalevich.icourse.GroupRepository;
import by.itacademy.mikhalevich.icourse.model.Group;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository("groupRepositoryOrmImpl")
public class GroupRepositoryOrmImpl extends AbstractRepositoryOrmImpl<Group> implements GroupRepository {

    public GroupRepositoryOrmImpl(){
        clazz = Group.class;
    }
}

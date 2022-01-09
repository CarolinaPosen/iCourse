package by.itacademy.mikhalevich.icourse.spring;

import by.itacademy.mikhalevich.icourse.model.Group;

import java.util.Map;
import java.util.Optional;

public interface NoGroupService {
    Map<Integer, Group> readGroups();
    Optional<Group> updateGroup(Group group);
    Group createGroup(Group group);
    Optional<Group> deleteGroup(Group group);
    Group getGroupById (Integer id);

}

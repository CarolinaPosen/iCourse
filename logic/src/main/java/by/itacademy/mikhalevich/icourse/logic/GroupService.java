package by.itacademy.mikhalevich.icourse.logic;

import by.itacademy.mikhalevich.icourse.model.Group;
import java.util.Map;
import java.util.Optional;

public interface GroupService {
    Map<Integer, Group> readGroups();
    Map<Integer, Group> updateGroup(Group group);
    Map<Integer, Group> createGroup(Group group);
    Map<Integer, Group> deleteGroup(Integer id);
    Group getGroupById (Integer id);

}

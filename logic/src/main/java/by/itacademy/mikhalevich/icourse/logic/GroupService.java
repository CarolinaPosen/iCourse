package by.itacademy.mikhalevich.icourse.logic;

import by.itacademy.mikhalevich.icourse.model.Group;
import java.util.Map;
import java.util.Optional;

public interface GroupService {
    Map<Integer, Group> readGroups();
    Map<Integer, Group> updateGroup(Group teacher);
    Map<Integer, Group> createGroup(Group teacher);
    Map<Integer, Group> deleteGroup(Integer id);
    Optional getGroupById (Integer id);

}

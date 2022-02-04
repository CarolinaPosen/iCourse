package by.itacademy.mikhalevich.icourse.base;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.model.Group;

import java.util.Map;

public interface GroupBaseRepository extends Repository<Group> {
    Map<Integer, Group> getGroupMap();
}

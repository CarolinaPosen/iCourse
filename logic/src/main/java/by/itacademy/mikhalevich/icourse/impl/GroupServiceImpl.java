package by.itacademy.mikhalevich.icourse.impl;

import by.itacademy.mikhalevich.icourse.GroupService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.model.Group;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Component()
public class GroupServiceImpl implements GroupService {
    private Repository groupRepository;

    public GroupServiceImpl() {
        this.groupRepository = RepositoryFactory.getGroupRepository();
    }

    @Override
    public Map<Integer, Group> readGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Map<Integer, Group> updateGroup(Group group) {
        groupRepository.save(group);
        return null;
    }

    @Override
    public Map<Integer, Group> createGroup(Group group) {
        return null;
    }

    @Override
    public Map<Integer, Group> deleteGroup(Integer id) {
        groupRepository.remove(new Group().withId(id));
        return null;
    }

    @Override
    public Group getGroupById(Integer id) {
        Optional group = groupRepository.find(id);
        if (group.isPresent()) {
            return (Group) group.get();
        } else {
            log.error("Trainer id: "+ id +" not exists");
            return null;
        }
    }

}

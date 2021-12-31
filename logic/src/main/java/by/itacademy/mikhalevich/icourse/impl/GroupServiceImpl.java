package by.itacademy.mikhalevich.icourse.impl;

import by.itacademy.mikhalevich.icourse.GroupService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.model.Group;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

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
    public Group createGroup(Group group) {
        return (Group) groupRepository.save(group);
    }

    @Override
    public Optional<Group> deleteGroup(Group group) {

        Optional deletedGroup = groupRepository.remove(group);
        if (deletedGroup.isEmpty()) {
            log.error("Group id: "+ group.getId() +" not exists");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: "+ group.getId() +" not exists");
        } else {
            return deletedGroup;
        }
    }

    @Override
    public Group getGroupById(Integer id) {
        Optional group = groupRepository.find(id);
        if (group.isEmpty()) {
            log.error("Group id: "+ id +" not exists");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: "+ id +" not exists");
        } else {
            return (Group) group.get();
        }
    }

}

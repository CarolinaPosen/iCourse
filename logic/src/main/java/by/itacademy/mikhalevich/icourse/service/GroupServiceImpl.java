package by.itacademy.mikhalevich.icourse.service;

import by.itacademy.mikhalevich.icourse.GroupRepository;
import by.itacademy.mikhalevich.icourse.GroupService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.model.Group;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Component("groupServiceImpl")
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;

    public GroupServiceImpl() {
        this.groupRepository = RepositoryFactory.getGroupRepository();
    }

    @Override
    public Map<Integer, Group> readGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<Group> updateGroup(Group group) {
        return Optional.of((Group) groupRepository.save(group));
    }

    @Override
    public Optional<Group> createGroup(Group group) {
        return Optional.of((Group) groupRepository.save(group));
    }

    @Override
    public Optional<Group> deleteGroup(Group group) {
        Optional<Group> deletedGroup = groupRepository.remove(group.getId());
        if (!deletedGroup.isPresent()) {
            log.error("Group id: " + group.getId() + " not exists");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + group.getId() + " not exists");
        } else {
            return deletedGroup;
        }
    }

    @Override
    public Optional<Group> getGroupById(Integer id) {
        Optional group = groupRepository.find(id);
        if (!group.isPresent()) {
            log.error("Group id: " + id + " not exists");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
        } else {
            return group;
        }
    }

}

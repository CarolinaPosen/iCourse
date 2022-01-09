package by.itacademy.mikhalevich.icourse.servicespring;

import by.itacademy.mikhalevich.icourse.GroupRepository;
import by.itacademy.mikhalevich.icourse.GroupService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.model.Group;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class GroupServiceSpringImpl implements GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public GroupServiceSpringImpl(@Qualifier("groupRepositoryOrmImpl") GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
        log.info("GroupRepository: {}", groupRepository);
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
        return Optional.of((Group)groupRepository.save(group));
    }

    @Override
    public Optional<Group> deleteGroup(Group group) {
        Optional<Group> deletedGroup = groupRepository.remove(group);
        if (deletedGroup.isEmpty()) {
            log.error("Group id: " + group.getId() + " not exists");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + group.getId() + " not exists");
        } else {
            return deletedGroup;
        }
    }

    @Override
    public Optional<Group> getGroupById(Integer id) {
        Optional<Group> group = groupRepository.find(id);
        if (group.isEmpty()) {
            log.error("Group id: " + id + " not exists");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
        } else {
            return group;
        }
    }

}

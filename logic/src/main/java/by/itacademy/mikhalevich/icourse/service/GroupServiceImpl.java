package by.itacademy.mikhalevich.icourse.service;

import by.itacademy.mikhalevich.icourse.GroupRepository;
import by.itacademy.mikhalevich.icourse.GroupService;
import by.itacademy.mikhalevich.icourse.TrainerRepository;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Trainer;
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
    private TrainerRepository trainerRepository;

    public GroupServiceImpl() {
        this.groupRepository = RepositoryFactory.getGroupRepository();
        this.trainerRepository = RepositoryFactory.getTrainerRepository();
    }

    @Override
    public Map<Integer, Group> read() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<Group> update(Group group) {
        Optional<Trainer> trainer = trainerRepository.find(group.getTrainer().getId());
        trainer.ifPresent(group::setTrainer);
        return Optional.of((Group) groupRepository.save(group));
    }

    @Override
    public Optional<Group> create(Group group) {
        return Optional.of((Group) groupRepository.save(group));
    }

    @Override
    public Optional<Group> delete(Integer id) {
        Optional<Group> deletedGroup = groupRepository.remove(id);
        if (!deletedGroup.isPresent()) {
            log.error("Group id: " + id + " not exists");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
        } else {
            return deletedGroup;
        }
    }

    @Override
    public Optional<Group> getById(Integer id) {
        Optional group = groupRepository.find(id);
        if (!group.isPresent()) {
            log.error("Group id: " + id + " not exists");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
        } else {
            return group;
        }
    }
}

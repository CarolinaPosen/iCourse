package by.itacademy.mikhalevich.icourse.service;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.TeacherService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.calculating.Accounting;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TrainerServiceImpl implements TeacherService {

//    public static final int PARAMETER_INDEX = 5;
    private Repository trainerRepository;
    private Repository roleRepository;
    private Repository groupRepository;

    public TrainerServiceImpl() {
        this.trainerRepository = RepositoryFactory.getTrainerRepository();
        this.roleRepository = RepositoryFactory.getRoleRepository();
        this.groupRepository = RepositoryFactory.getGroupRepository();
    }

    @Override
    public Map readTeachers() {
        return trainerRepository.findAll();
    }

    @Override
    public Optional<Trainer> updateTrainer(Trainer trainer) {
        Role updateRole = (Role) roleRepository.findByName(trainer.getRole().getTitle()).get();
        trainer.withRole(updateRole);
        return Optional.ofNullable((Trainer) trainerRepository.save(trainer));
    }

    @Override
    public Optional<Trainer> createTrainer(Trainer trainer) {
        Role updateRole = (Role) roleRepository.findByName(trainer.getRole().getTitle()).get();
        trainer.withRole(updateRole);
        return Optional.ofNullable((Trainer) trainerRepository.save(trainer));
    }

    @Override
    public Optional<Trainer> deleteTrainer(Integer id) {

        Optional<Trainer> optionalTrainer = trainerRepository.find(id);
        Trainer trainer;
        if (optionalTrainer.isPresent()) {
            trainer = optionalTrainer.get();
        } else {
            log.error("Trainer id: "+ id +" not exists");
            return Optional.empty();
        }

        if (!trainer.getGroups().isEmpty()) {
            Group trainerGroup = trainer.getGroups().stream().findFirst().get();
            trainerGroup.removeTrainer(trainer);
            groupRepository.save(trainerGroup);
        } else {
            log.error("Group id: "+ id +" not exists");
        }
        return trainerRepository.remove(trainer.getId());
    }

    @Override
    public Optional<Trainer> getTrainerById(Integer id) {
        Optional<Trainer> trainer = trainerRepository.find(id);
        if (trainer.isPresent()) {
            return trainer;
        } else {
            log.error("Trainer id: "+ id +" not exists");
            return Optional.of(new Trainer());
        }
    }

    @Override
    public BigDecimal averageSalary(Integer id, int perMonth) {

        Optional<Trainer> optionalTrainer = trainerRepository.find(id);
        Trainer trainer = optionalTrainer.orElseGet(Trainer::new);

        List<BigDecimal> list = trainer.getSalaries()
                .stream()
                .map(Salary::getSalary)
                .collect(Collectors.toList());

        BigDecimal averageSalary = Accounting.average(list, perMonth);
        return averageSalary;
    }
}

package by.itacademy.mikhalevich.icourse.impl;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.TeacherService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.calculating.Accounting;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
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
    public Map<Integer, Trainer> updateTrainer(Trainer trainer) {
        Role updateRole = (Role) roleRepository.findByName(trainer.getRole().getTitle()).get();
        trainer.withRole(updateRole);
        trainerRepository.save(trainer);
        return null;
    }

    @Override
    public Map<Integer, Trainer> createTrainer(Trainer trainer) {
        Role updateRole = (Role) roleRepository.findByName(trainer.getRole().getTitle()).get();
        trainer.withRole(updateRole);
        trainerRepository.save(trainer);
        return null;
    }

    @Override
    public Map<Integer, Trainer> deleteTrainer(Integer id) {

        Optional<Trainer> optionalTrainer = trainerRepository.find(id);
        Trainer trainer;
        if (optionalTrainer.isPresent()) {
            trainer = optionalTrainer.get();
        } else {
            log.error("Trainer id: "+ id +" not exists");
            return null;
        }

        if (!trainer.getGroups().isEmpty()) {
            Group trainerGroup = trainer.getGroups().stream().findFirst().get();
            trainerGroup.removeTrainer(trainer);
            groupRepository.save(trainerGroup);
        } else {
            log.error("Group id: "+ id +" not exists");
        }

        trainerRepository.remove(trainer);
        return null;
    }

    @Override
    public Trainer getTrainerById(Integer id) {
        Optional trainer = trainerRepository.find(id);
        if (trainer.isPresent()) {
            return (Trainer) trainer.get();
        } else {
            log.error("Trainer id: "+ id +" not exists");
            return null;
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
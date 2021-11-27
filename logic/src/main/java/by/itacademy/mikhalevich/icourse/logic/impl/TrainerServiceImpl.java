package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.jdbc.TeacherRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.jpa.GroupRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.jpa.RoleRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.jpa.TrainerRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.logic.TeacherService;
import by.itacademy.mikhalevich.icourse.logic.calculating.Accounting;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
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

    public TrainerServiceImpl(DataSource dataSource) {
        this.trainerRepository = TrainerRepositoryJpaImpl.getInstance();
        this.roleRepository = RoleRepositoryJpaImpl.getInstance();
        this.groupRepository = GroupRepositoryJpaImpl.getInstance();
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
        Optional trainer = trainerRepository.find(id);
        Trainer trainer1;
        if (trainer.isPresent()) {
            trainer1 = (Trainer) trainer.get();
        } else {
            log.error("Trainer id: "+ id +" not exists");
            return null;
        }
        Optional<Group> groupOptional = trainer1.getGroups().stream().findFirst();
        Group group;
        if (groupOptional.isPresent()) {
            group = (Group) groupOptional.get();
        } else {
            log.error("Trainer id: "+ id +" not exists");
            return null;
        }

        trainer1.removeGroup(group);

//        groupRepository.save(group);

        trainerRepository.remove(trainer1);
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

package by.itacademy.mikhalevich.icourse.servicespring;

import by.itacademy.mikhalevich.icourse.*;
import by.itacademy.mikhalevich.icourse.calculating.Accounting;
import by.itacademy.mikhalevich.icourse.model.*;
import by.itacademy.mikhalevich.icourse.model.auth.Credential;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component("trainerServiceSpringImpl")
public class TrainerServiceSpringImpl implements TeacherService {

    private Repository trainerRepository;
    private Repository roleRepository;
    private Repository groupRepository;

    @Autowired
    public TrainerServiceSpringImpl(
            @Qualifier("trainerRepositoryOrmImpl") TrainerRepository trainerRepository,
            @Qualifier("roleRepositoryOrmImpl") RoleRepository roleRepository
//            @Qualifier("groupRepositoryOrmImpl") GroupRepository groupRepository
    ) {
        this.trainerRepository = trainerRepository;
        this.roleRepository = roleRepository;
//        this.groupRepository = groupRepository;
    }

    @Override
    public Map read() {
        return trainerRepository.findAll();
    }

    @Override
    public Optional<Trainer> update(Trainer trainer) {
        //Credential updateCredential = (Credential) roleRepository.findByName(trainer.getRole().getTitle()).get();
       // trainer.withRole(updateRole);
        return Optional.ofNullable((Trainer) trainerRepository.save(trainer));
    }

    @Override
    public Optional<Trainer> create(Trainer trainer) {
        //ExRole updateRole = (ExRole) roleRepository.findByName(trainer.getRole().getTitle()).get();
        //trainer.withRole(updateRole);
        return Optional.ofNullable((Trainer) trainerRepository.save(trainer));
    }

    @Override
    public Optional<Trainer> delete(Integer id) {
        Optional<Trainer> optionalTrainer = trainerRepository.find(id);

        if (!optionalTrainer.get().getGroups().isEmpty()) {
            Group trainerGroup = optionalTrainer.get().getGroups().stream().findFirst().get();
            trainerGroup.removeTrainer(optionalTrainer.get());
        } else {
            log.error("Trainer id: "+ id +" does`t have attached group");
        }
        return trainerRepository.remove(optionalTrainer.get().getId());
    }

    @Override
    public Optional<Trainer> getById(Integer id) {
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

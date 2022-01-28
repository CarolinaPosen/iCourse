package by.itacademy.mikhalevich.icourse.servicememory;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.Service;
import by.itacademy.mikhalevich.icourse.TeacherService;
import by.itacademy.mikhalevich.icourse.calculating.Accounting;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.repository.RepositoryMemoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component("trainerServiceMemoryImpl")
public class TrainerServiceMemoryImpl implements Service<Trainer> {

    private RepositoryMemoryImpl trainerRepository = new RepositoryMemoryImpl();


    @Override
    public Map<Integer, Trainer> read() {
        return trainerRepository.findAll();
    }

    @Override
    public Optional<Trainer> update(Trainer trainer) {
        return Optional.empty();
    }

    @Override
    public Optional<Trainer> create(Trainer trainer) {
        return null;
    }

    @Override
    public Optional<Trainer> delete(Integer id) {
        return trainerRepository.remove(id);
    }

    @Override
    public Optional<Trainer> getById(Integer id) {
        return trainerRepository.find(id);
    }
}

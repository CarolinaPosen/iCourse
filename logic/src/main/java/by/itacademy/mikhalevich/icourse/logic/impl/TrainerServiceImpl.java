package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.jdbc.Repository;
import by.itacademy.mikhalevich.icourse.jdbc.TeacherRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.logic.TeacherService;
import by.itacademy.mikhalevich.icourse.logic.calculating.Accounting;
import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.model.Trainer;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TrainerServiceImpl implements TeacherService {

    private Repository trainerRepository;

    public TrainerServiceImpl(DataSource dataSource) {
        this.trainerRepository = TeacherRepositoryPostgres.getInstance(dataSource);
    }

    @Override
    public Map<Integer, Trainer> readTeachers() {
        return trainerRepository.findAll();
    }

    @Override
    public Map<Integer, Trainer> updateTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
        return null;
    }

    @Override
    public Map<Integer, Trainer> createTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
        return null;
    }

    @Override
    public Map<Integer, Trainer> deleteTrainer(Integer id) {
        trainerRepository.remove(new Trainer().withId(id));
        return null;
    }

    @Override
    public Optional getTrainerById(Integer id) {
        return trainerRepository.find(id);
    }

    @Override
    public BigDecimal averageSalary(Integer id, int countOfMonth) {

        Optional<Trainer> optionalTrainer = trainerRepository.find(id);
        Trainer trainer = optionalTrainer.orElseGet(Trainer::new);
        BigDecimal averageSalary = Accounting.average((List<Integer>) trainer.getSalary(), countOfMonth).setScale(2, RoundingMode.HALF_UP);
        return averageSalary;
    }
}

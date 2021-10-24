package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.jdbc.TrainerRepository;
import by.itacademy.mikhalevich.icourse.logic.TeacherService;
import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.model.Trainer;

import java.math.BigDecimal;
import java.util.Map;

public class TrainerServiceImpl implements TeacherService {


    @Override
    public Map<Integer, Trainer> readTeachers() {
        TrainerRepository trainerRepository = new TrainerRepository();
        return trainerRepository.allTrainers();
    }

    @Override
    public Map<Integer, Trainer> updateTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Map<Integer, Trainer> createTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Map<Integer, Trainer> deleteTeacher(Integer id) {
        return null;
    }

    @Override
    public Trainer getTeacherById(Integer id) {
        TrainerRepository trainerRepository = new TrainerRepository();
        return trainerRepository.getTrainerById(id);
    }

    @Override
    public BigDecimal averageSalary(Integer id, int countOfMonth) {
        return null;
    }
}

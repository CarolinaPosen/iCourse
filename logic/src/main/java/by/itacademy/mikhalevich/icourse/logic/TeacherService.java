package by.itacademy.mikhalevich.icourse.logic;

import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.model.Trainer;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public interface TeacherService {

	Map<Integer, Trainer> readTeachers();
	Map<Integer, Trainer> updateTrainer(Trainer trainer);
	Map<Integer, Trainer> createTrainer(Trainer trainer);
	Map<Integer, Trainer> deleteTrainer(Integer id);
	Optional getTrainerById (Integer id);
	BigDecimal averageSalary(Integer id);


}

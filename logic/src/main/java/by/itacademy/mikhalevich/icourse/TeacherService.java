package by.itacademy.mikhalevich.icourse;

import by.itacademy.mikhalevich.icourse.model.Trainer;

import java.math.BigDecimal;
import java.util.Map;

public interface TeacherService {

	Map<Integer, Trainer> readTeachers();
	Map<Integer, Trainer> updateTrainer(Trainer trainer);
	Map<Integer, Trainer> createTrainer(Trainer trainer);
	Map<Integer, Trainer> deleteTrainer(Integer id);
	Trainer getTrainerById (Integer id);
	BigDecimal averageSalary(Integer id, int month);


}

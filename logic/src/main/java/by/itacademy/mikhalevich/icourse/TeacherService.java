package by.itacademy.mikhalevich.icourse;

import by.itacademy.mikhalevich.icourse.model.Trainer;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public interface TeacherService extends Service<Trainer> {

//	Map<Integer, Trainer> readTeachers();
//	Optional<Trainer> updateTrainer(Trainer trainer);
//	Optional<Trainer> createTrainer(Trainer trainer);
//	Optional<Trainer> deleteTrainer(Integer id);
//	Optional<Trainer> getTrainerById (Integer id);
	BigDecimal averageSalary(Integer id, int month);


}

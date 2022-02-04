package by.itacademy.mikhalevich.icourse.base;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Trainer;

import java.util.Map;

public interface TrainerBaseRepository extends Repository<Trainer> {
    Map<Integer, Trainer> getTrainerMap();
}

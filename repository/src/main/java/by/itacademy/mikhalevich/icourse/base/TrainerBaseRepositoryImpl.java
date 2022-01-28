package by.itacademy.mikhalevich.icourse.base;

import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("trainerBaseRepositoryImpl")
public class TrainerBaseRepositoryImpl extends BaseRepositoryImpl<Trainer> implements TrainerBaseRepository {

    public TrainerBaseRepositoryImpl() {
        super();
        clazz = Trainer.class;
    }

    @Override
    public Map<Integer, Trainer> getTrainerMap() {
        em.createQuery("from Trainer").getResultList();
        return null;
    }
}

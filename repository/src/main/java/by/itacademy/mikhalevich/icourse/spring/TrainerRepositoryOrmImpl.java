package by.itacademy.mikhalevich.icourse.spring;

import by.itacademy.mikhalevich.icourse.StudentRepository;
import by.itacademy.mikhalevich.icourse.TrainerRepository;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository("trainerRepositoryOrmImpl")
public class TrainerRepositoryOrmImpl extends AbstractRepositoryOrmImpl<Trainer> implements TrainerRepository {

    public TrainerRepositoryOrmImpl(){
        clazz = Trainer.class;
    }

    @Override
    protected TypedQuery<Trainer> findByNameQuery(String name) {
        return null;
    }
}

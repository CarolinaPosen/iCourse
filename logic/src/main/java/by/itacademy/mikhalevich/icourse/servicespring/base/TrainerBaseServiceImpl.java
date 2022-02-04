package by.itacademy.mikhalevich.icourse.servicespring.base;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("trainerBaseServiceImpl")
@RequiredArgsConstructor
public class TrainerBaseServiceImpl extends BaseServiceImpl<Trainer> implements by.itacademy.mikhalevich.icourse.Service<Trainer> {

    @Autowired
    @Qualifier("trainerBaseRepositoryImpl")
    private Repository<Trainer> repository;

    @Override
    protected Repository<Trainer> getRepository() {
        return repository;
    }
}

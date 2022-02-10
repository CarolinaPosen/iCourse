package by.itacademy.mikhalevich.icourse.servicespring.data;

import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.spring.data.TrainerSpringDataJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("trainerSpringDataServiceImpl")
@RequiredArgsConstructor
public class TrainerSpringDataServiceImpl implements by.itacademy.mikhalevich.icourse.Service<Trainer> {

    @Autowired
    private TrainerSpringDataJpaRepository repository;


    @Override
    public Map<Integer, Trainer> read() {
        List<Trainer> trainers = repository.findAll();
        return trainers.stream().collect(Collectors.toMap(Trainer::getId, Function.identity()));
    }

    @Override
    public Optional<Trainer> update(Trainer trainer) {
        return Optional.ofNullable(repository.save(trainer));
    }

    @Override
    public Optional<Trainer> create(Trainer trainer) {
        return Optional.ofNullable(repository.save(trainer));
    }

    @Override
    public Optional<Trainer> delete(Integer id) {
        Optional<Trainer> trainer = repository.findById(id);
        repository.deleteById(id);
        return trainer;
    }

    @Override
    public Optional<Trainer> getById(Integer id) {
        return repository.findById(id);
    }
}

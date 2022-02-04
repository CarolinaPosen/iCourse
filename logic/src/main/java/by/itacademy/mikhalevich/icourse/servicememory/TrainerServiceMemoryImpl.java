package by.itacademy.mikhalevich.icourse.servicememory;

import by.itacademy.mikhalevich.icourse.Service;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.repository.RepositoryMemoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Component("trainerServiceMemoryImpl")
public class TrainerServiceMemoryImpl implements Service<Trainer> {

    private RepositoryMemoryImpl trainerRepository = new RepositoryMemoryImpl();

    @Override
    public Map<Integer, Trainer> read() {
        return trainerRepository.findAll();
    }

    @Override
    public Optional<Trainer> update(Trainer trainer) {
        return Optional.empty();
    }

    @Override
    public Optional<Trainer> create(Trainer trainer) {
        return null;
    }

    @Override
    public Optional<Trainer> delete(Integer id) {
        return trainerRepository.remove(id);
    }

    @Override
    public Optional<Trainer> getById(Integer id) {
        return trainerRepository.find(id);
    }
}

package by.itacademy.mikhalevich.icourse.repository;

import by.itacademy.mikhalevich.icourse.TrainerRepository;
import by.itacademy.mikhalevich.icourse.exception.DataBaseErrorException;
import by.itacademy.mikhalevich.icourse.model.AbstractEntity;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static by.itacademy.mikhalevich.icourse.repository.MemoryRepository.trainers;

@Slf4j
@org.springframework.stereotype.Repository
@RequiredArgsConstructor
public class RepositoryMemoryImpl implements TrainerRepository {


    @Override
    public Map<Integer, Trainer> findAll() {
        List<Trainer> trainersMap = new ArrayList<>();
        for (Map<String, String> listItem : trainers) {
            trainersMap.add(new Trainer()
                    .withId(Integer.parseInt(listItem.get("id")))
                    .withName(listItem.get("name"))
                    .withLogin(listItem.get("login"))
                    .withPassword(listItem.get("password"))
                    .withRole(new Role().withId(1).withTitle("Admin")));
        }
        Map<Integer, Trainer> result = trainersMap.stream().collect(Collectors.toMap(Trainer::getId, Function.identity()));
        return result;
    }

    @Override
    public Optional<Trainer> find(Integer id) {

            Optional<Trainer> foundTrainer = trainers.stream()
                    .filter(trainer -> trainer.get("id").equals(id.toString()))
                    .map(trainer -> new Trainer()
                            .withId(Integer.parseInt(trainer.get("id")))
                            .withName(trainer.get("name"))
                            .withLogin(trainer.get("login"))
                            .withPassword(trainer.get("password")))
                    .findAny();
            return foundTrainer;
    }

    @Override
    public Optional<Trainer> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Trainer save(Trainer entity) {
        return null;
    }

    @Override
    public Optional<Trainer> remove(Integer id) {
        Map<String, String> cartage = trainers.stream()
                .filter(removedTrainer -> removedTrainer.get("id").equals(id.toString()))
                .findAny().get();
        Optional<Trainer> removedTrainer = Optional.ofNullable(find(id).get());
        trainers.remove(cartage);
        return removedTrainer;
    }
}

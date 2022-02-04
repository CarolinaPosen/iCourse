package by.itacademy.mikhalevich.icourse.repository;

import java.util.*;

public class MemoryRepository {

    public static List<Map<String, String>> trainers = new ArrayList<Map<String, String>>() {{
       add(new HashMap<String, String>() {{put("id", "1"); put("name", "Memory Trainer 1"); put("login", "T1"); put("password", "1"); put("role_id", "1");}});
       add(new HashMap<String, String>() {{put("id", "2"); put("name", "Memory Trainer 2"); put("login", "T2"); put("password", "2"); put("role_id", "2");}});
       add(new HashMap<String, String>() {{put("id", "3"); put("name", "Memory Trainer 3"); put("login", "T3"); put("password", "3"); put("role_id", "3");}});
    }};

//    public List<Trainer> findAll(){
//        List<Trainer> trainersMap = new ArrayList<>();
//        for(Map<String, String> listItem : trainers){
//                trainersMap.add(new Trainer()
//                        .withId(Integer.parseInt(listItem.get("id")))
//                        .withName(listItem.get("name"))
//                        .withLogin(listItem.get("login"))
//                        .withPassword(listItem.get("password"))
//                        .withRole(new Role().withId(1).withTitle("Admin")));
//        }
//        return trainersMap;
//    }
//
//    public Optional<Trainer> find(Integer id) {
//            Optional<Trainer> foundTrainer = trainers.stream()
//                    .filter(trainer -> trainer.get("id").equals(id.toString()))
//                    .map(trainer -> new Trainer()
//                            .withId(Integer.parseInt(trainer.get("id")))
//                            .withName(trainer.get("name"))
//                            .withLogin(trainer.get("login"))
//                            .withPassword(trainer.get("password")))
//                    .findAny();
//        return foundTrainer;
//    }
//
//    public Optional findByName(String name) {
//        return Optional.empty();
//    }
//
//    public Trainer save(Trainer trainer) {
//            trainers.add(new HashMap<String, String>() {{
//                put("id", trainer.getId().toString());
//                put("name", trainer.getName());
//                put("login", trainer.getLogin());
//                put("password", trainer.getPassword());
//                put("role_id", trainer.getRole().getId().toString());}});
//        return trainer;
//    }
//
//    public Optional<Trainer> remove(Integer id) {
//        Map<String, String> cartage = trainers.stream()
//                .filter(trainer -> trainer.get("id").equals(id.toString()))
//                .findAny().get();
//        Optional<Trainer> removedTrainer = Optional.ofNullable(find(id).get());
//        trainers.remove(cartage);
//        return removedTrainer;
//    }
}

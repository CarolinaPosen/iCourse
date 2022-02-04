package by.itacademy.mikhalevich.icourse.repository;

import java.util.*;

public class MainMemoryRepository {

    public static List<Map<String, String>> trainers = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{
            put("id", "1");
            put("name", "Memory Trainer 1");
            put("login", "T1");
            put("password", "1");
            put("role_id", "1");
        }});
        add(new HashMap<String, String>() {{
            put("id", "2");
            put("name", "Memory Trainer 2");
            put("login", "T2");
            put("password", "2");
            put("role_id", "2");
        }});
        add(new HashMap<String, String>() {{
            put("id", "3");
            put("name", "Memory Trainer 3");
            put("login", "T3");
            put("password", "3");
            put("role_id", "3");
        }});
    }};

    public static void main(String[] args) {

        Integer id = 2;

        Map<String, String> cartage = trainers.stream()
                .filter(trainer -> trainer.get("id").equals(id.toString()))
                .findAny().get();

        trainers.remove(cartage);

        for ( Map<String, String> element: trainers
             ) {
            System.out.println(element);
        }

    }

}

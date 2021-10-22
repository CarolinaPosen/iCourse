package by.itacademy.mikhalevich.icourse.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class Group extends AbstractEntity<Integer> {
    private String name;
    private Teacher teacher;
    private HashMap<Integer, String> themes = new HashMap<>();
    private HashMap<Integer, Student> students = new HashMap<>();
}

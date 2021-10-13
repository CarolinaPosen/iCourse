package by.itacademy.mikhalevich.icourse.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

    {
        marks = new ArrayList<>();
    }

    private List<Integer> marks;

    public Student() {
    }

    public Student(long id, String name, int age) {
        super(id, name, age);

    }

    @Override
    public String getInfo() {
        return toString();
    }
}

package by.itacademy.mikhalevich.icourse.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private List<Integer> salary = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(long id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(long id, String name, int age, List<Integer> salary) {
        super(id, name, age);
        this.salary = salary;
    }

    public List<Integer> getSalary() {
        return salary;
    }

    public void setSalary(List<Integer> salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                super.toString()+
                "salary=" + salary +
                '}';
    }

    @Override
    public String getInfo() {
        return toString();
    }
}

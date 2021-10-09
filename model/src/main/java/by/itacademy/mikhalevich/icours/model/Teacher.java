package by.itacademy.mikhalevich.icours.model;

public class Teacher extends Person {

    private int salary;

    public Teacher() {
    }

    public Teacher(long id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(long id, String name, int age, int salary) {
        super(id, name, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
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

package by.itacademy.mikhalevich.icours.repository;

import by.itacademy.mikhalevich.icours.model.Person;
import by.itacademy.mikhalevich.icours.model.Student;
import by.itacademy.mikhalevich.icours.model.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDataSource {

    private Map<Integer, Teacher> teachersMap;

    public ListDataSource() {
        this.teachersMap = createTeacherList();
    }

    public Map<Integer, Teacher> getTeachersMap() {
        return teachersMap;
    }

    public void setTeachersMap(Map<Integer, Teacher> teachersMap) {
        this.teachersMap = teachersMap;
    }

    public List<Student> initStudentModel() {
        return List.of(
                new Student(1, "Anna", 30),
                new Student(2, "Fedor", 35),
                new Student(3, "Viktor", 30)
        );
    }

    public static Map<Integer, Teacher> createTeacherList() {
        HashMap<Integer, Teacher> teachers = new HashMap<>();

        teachers.put(1, new Teacher(1, "John", 30, 2000));
        teachers.put(2, new Teacher(2, "John", 30, 2000));
        teachers.put(3, new Teacher(3, "John", 30, 2000));
        teachers.put(4, new Teacher(4, "John", 30, 2000));
        teachers.put(5, new Teacher(5, "John", 30, 2000));
        teachers.put(6, new Teacher(6, "John", 30, 2000));
        teachers.put(7, new Teacher(7, "John", 30, 2000));
        teachers.put(8, new Teacher(8, "John", 30, 2000));
        teachers.put(9, new Teacher(9, "John", 30, 2000));
        teachers.put(10, new Teacher(10, "John", 30, 2000));
        return teachers;
    }

    public Map<Integer, Teacher> updateTeacher(Teacher teacher){
        teachersMap.put((int) teacher.getId(), teacher);
        return teachersMap;
    }

    public Map<Integer, Teacher> deleteTeacher (Integer id){
        teachersMap.remove(id);
        return teachersMap;
    }

    public Map<Integer, Teacher> createTeacher (Teacher teacher){
        teachersMap.put((int) teacher.getId(), teacher);
        return teachersMap;
    }

    public static void printPersonList(Map<Integer, Person> map) {
        for (Map.Entry<Integer, Person> p : map.entrySet()) {
            System.out.println(p.getKey() + " " + p.getValue());
        }
    }


}

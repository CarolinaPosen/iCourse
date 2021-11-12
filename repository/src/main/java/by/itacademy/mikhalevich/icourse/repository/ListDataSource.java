package by.itacademy.mikhalevich.icourse.repository;

import by.itacademy.mikhalevich.icourse.model.Person;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDataSource {

    private Map<Integer, Trainer> teachersMap;

    public ListDataSource() {
        this.teachersMap = createTeacherList();
    }

    public Map<Integer, Trainer> getTeachersMap() {
        return teachersMap;
    }

    public void setTeachersMap(Map<Integer, Trainer> teachersMap) {
        this.teachersMap = teachersMap;
    }

    public static Map<Integer, Trainer> createTeacherList() {
        Map<Integer, Trainer> teachers = new HashMap<>();

/*        teachers.put(1, new Trainer(1, "John", 30, List.of(10,22,36,48,54,61,75,88,97,160,211,112)));
        teachers.put(2, new Trainer(2, "Petr", 23, List.of(12,255,35,444,555,64,73,86,55,1503,415,112)));
        teachers.put(3, new Trainer(3, "Ivan", 16, List.of(15,25,36,425,525,645,722,885,988,105,151,122)));
        teachers.put(4, new Trainer(4, "Santa", 35, List.of(12,22,32,42,52,62,72,82,92,105,115,1255)));
        teachers.put(5, new Trainer(5, "Eli", 23, List.of(1,2,3,4,5,6,7,8,9,10,11,12)));
        teachers.put(6, new Trainer(6, "MARS", 88, List.of(1,2,3,4,5,6,7,8,9,10,11,12)));
        teachers.put(7, new Trainer(7, "Mr.Proper", 20, List.of(1,2,3,4,5,6,7,8,9,10,11,12)));
        teachers.put(8, new Trainer(8, "Smith", 18, List.of(1,2,3,4,5,6,7,8,9,10,11,12)));
        teachers.put(9, new Trainer(9, "Nikolai", 45, List.of(1,2,3,4,5,6,7,8,9,10,11,12)));
        teachers.put(10, new Trainer(10, "Jo", 43, List.of(1,2,3,4,5,6,7,8,9,10,11,12)));*/
        return teachers;
    }

    public Map<Integer, Trainer> updateTeacher(Trainer teacher){
        teachersMap.put((int) teacher.getId(), teacher);
        return teachersMap;
    }

    public Map<Integer, Trainer> deleteTeacher (Integer id){
        teachersMap.remove(id);
        return teachersMap;
    }

    public Map<Integer, Trainer> createTeacher (Trainer teacher){
        teachersMap.put((int) teacher.getId(), teacher);
        return teachersMap;
    }

    public Trainer getTeacherById(Integer id){
        return teachersMap.get(id);
    }

    public static void printPersonList(Map<Integer, Person> map) {
        for (Map.Entry<Integer, Person> p : map.entrySet()) {
            System.out.println(p.getKey() + " " + p.getValue());
        }
    }


}

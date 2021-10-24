package by.itacademy.mikhalevich.icourse.model;

import lombok.*;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Group extends AbstractEntity<Integer> {
    private String title;
    private Teacher teacher;
    private HashMap<Integer, String> themes = new HashMap<>();
    private HashMap<Integer, Student> students = new HashMap<>();

    public Group withId(Integer id){
        setId(id);
        return this;
    }

    public Group withTitle(String name){
        setTitle(name);
        return this;
    }

    public Group withTeacher(Teacher teacher){
        setTeacher(teacher);
        return this;
    }

    public Group addTheme(Integer id, String theme){
        themes.put(id, theme);
        return this;
    }

    public Group addStudent(Integer id, Student student){
        students.put(id, student);
        return this;
    }

}

package by.itacademy.mikhalevich.icourse.model;

import lombok.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Group extends AbstractEntity<Integer> {
    private String title;
    private Trainer trainer;
    private Set<Theme> themes = new HashSet<>();
    private Set<Student> students = new HashSet<>();

    public Group withId(Integer id){
        setId(id);
        return this;
    }

    public Group withTitle(String name){
        setTitle(name);
        return this;
    }

    public Group withTeacher(Trainer trainer){
        setTrainer(trainer);
        return this;
    }

    public Group addTheme(Theme theme){
        themes.add(theme);
        return this;
    }

    public Group addStudent(Student student){
        students.add(student);
        return this;
    }

}

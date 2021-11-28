package by.itacademy.mikhalevich.icourse.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="class", schema = "public")
public class Group extends AbstractEntity {
    private String title;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "teacher_id")
    private Trainer trainer;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(name = "theme_class",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_id"))
    private Set<Theme> themes = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(name = "student_class",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
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

    public void addTrainer(Trainer trainer){
        this.setTrainer(trainer);
        trainer.addGroup(this);
    }

    public void removeTrainer(Trainer trainer){
        this.setTrainer(null);
//        trainer.addGroup(null);
    }

}

package by.itacademy.mikhalevich.icourse.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@ToString(callSuper = true, exclude = "groups")
@EqualsAndHashCode(callSuper = true, exclude = "groups")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends AbstractEntity{

    private String name;
    private String login;
    private String password;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Mark> marks = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(name = "student_class",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id"))
    private Set<Group> groups = new HashSet<>();

    public Student withId(Integer id){
        setId(id);
        return this;
    }

    public Student withName(String name) {
        setName(name);
        return this;
    }

    public Student withLogin(String login){
        setLogin(login);
        return this;
    }
    public Student withPassword(String password){
        setPassword(password);
        return this;
    }
    public Student withRole(Role role){
        setRole(role);
        return this;
    }

    public Student addMark(Mark mark){
        if(mark!=null){
            marks.add(mark);
            mark.setStudent(this);
        }
        return this;
    }

/*    public Student addGroup(Group group){
        if(group!=null){
            groups.add(group);
        }
        return this;
    }*/

//    @Override
//    public String toString() {
//        return String.format("Student [id=%s, name=%s, login=%s, role=%s]", getId(), name, login, role);
//    }

}

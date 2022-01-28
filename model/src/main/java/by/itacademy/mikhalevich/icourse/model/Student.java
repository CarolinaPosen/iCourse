package by.itacademy.mikhalevich.icourse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"groups", "marks"})
@EqualsAndHashCode(callSuper = true, exclude = {"groups"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Student extends AbstractEntity{

    private String name;
    private String login;
    private String password;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;

    //    @JsonManagedReference
    @OneToMany(mappedBy = "student", cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.DETACH})
    private Set<Mark> marks = new HashSet<>();

    @JsonBackReference
    @ManyToMany()
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

    public Student addGroup(Group group){
        if(group!=null){
            groups.add(group);
        }
        return this;
    }

}



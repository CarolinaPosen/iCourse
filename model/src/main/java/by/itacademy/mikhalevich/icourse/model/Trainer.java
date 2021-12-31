package by.itacademy.mikhalevich.icourse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"salaries", "groups"})
@ToString(callSuper = true, exclude = {"salaries", "groups"})
@Entity
@Table(name="teacher", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Trainer extends AbstractEntity {
    private String name;
    private String login;
    private String password;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "role_id")
    private Role role;

    @JsonBackReference
    @OneToMany(mappedBy = "trainer", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    private Set<Group> groups = new LinkedHashSet<>();

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Salary> salaries = new LinkedHashSet<>();

    public Trainer withId(Integer id){
        setId(id);
        return this;
    }

    public Trainer withName(String name) {
        setName(name);
        return this;
    }
    public Trainer withLogin(String login){
        setLogin(login);
        return this;
    }
    public Trainer withPassword(String password){
        setPassword(password);
        return this;
    }
    public Trainer withRole(Role role){
        setRole(role);
        return this;
    }

    public Trainer withSalaries(Set<Salary> salaries){
        setSalaries(salaries);
        return this;
    }

    public Trainer addSalary(Salary salary){
        if(salary!=null){
            salaries.add(salary);
            salary.setTrainer(this);
        }
        return this;
    }

    public void addGroup(Group group) {
        groups.add(group);
        group.setTrainer(this);
    }

    public void removeGroup(Group group) {
        group.setTrainer(null);
        //this.groups.remove(group);
    }

//    @Override
//    public String toString() {
//        return String.format("Trainer [id=%s, name=%s, login=%s, password=%s, role=%s, salary=%s]", getId(), name, login, password, role, salaries);
//    }
}

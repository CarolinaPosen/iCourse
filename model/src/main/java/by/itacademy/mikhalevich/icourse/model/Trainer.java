package by.itacademy.mikhalevich.icourse.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "salaries")

public class Trainer extends AbstractEntity<Integer> {
    private String name;
    private String login;
    private String password;
    private Role role;
    private Set<Salary> salaries = new HashSet<>();

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

    public Trainer addSalary(Salary salary){
        if(salary!=null){
            salaries.add(salary);
        }
        return this;
    }

    @Override
    public String toString() {
        return String.format("Trainer [id=%s, name=%s, login=%s, password=%s, role=%s, salary=%s]", getId(), name, login, password, role, salaries);
    }
}

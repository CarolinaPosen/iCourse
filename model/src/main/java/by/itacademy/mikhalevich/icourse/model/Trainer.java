package by.itacademy.mikhalevich.icourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainer extends AbstractEntity<Integer> {
    private String name;
    private String login;
    private String password;
    private int role;
    private HashMap<Integer, Integer> salary = new HashMap<>();

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
    public Trainer withRole(int role){
        setRole(role);
        return this;
    }

    public Trainer addSalary(Integer month, Integer sumPerMonth){
        if(month!=null){
            salary.put(month, sumPerMonth);
        }
        return this;
    }

    @Override
    public String toString() {
        return String.format("Trainer [id=%s, name=%s, login=%s, password=%s, role=%s, salary=%s]", getId(), name, login, password, role, salary);
    }
}

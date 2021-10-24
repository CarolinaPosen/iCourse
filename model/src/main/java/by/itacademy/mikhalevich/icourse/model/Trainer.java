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

    public Trainer addSalary(Integer themeId, Integer mark){
        if(mark!=null){
            salary.put(themeId, mark);
        }
        return this;
    }

    @Override
    public String toString() {
        return String.format("Student [id=%s, name=%s, login=%s, role=%s]", getId(), name, login, role);
    }
}

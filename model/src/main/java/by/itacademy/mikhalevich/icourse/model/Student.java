package by.itacademy.mikhalevich.icourse.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student extends AbstractEntity<Integer>{

    private String name;
    private String login;
    private String password;
    private int role;
    private HashMap<Integer, Integer> marks = new HashMap<>();

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
    public Student withRole(int role){
        setRole(role);
        return this;
    }

    public Student addMark(Integer themeId, Integer mark){
        if(mark!=null){
            marks.put(themeId, mark);
        }
        return this;
    }

}

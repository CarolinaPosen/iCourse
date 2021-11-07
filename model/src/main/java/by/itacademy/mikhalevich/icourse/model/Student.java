package by.itacademy.mikhalevich.icourse.model;


import lombok.*;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends AbstractEntity<Integer>{

    private String name;
    private String login;
    private String password;
    private Role role;
    private Set<Mark> marks = new HashSet<>();
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
        }
        return this;
    }

    public Student addGroup(Group group){
        if(group!=null){
            groups.add(group);
        }
        return this;
    }

    @Override
    public String toString() {
        return String.format("Student [id=%s, name=%s, login=%s, role=%s]", getId(), name, login, role);
    }

}

package by.itacademy.mikhalevich.icourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theme extends AbstractEntity {
    private String title;
    private Set<Group> groups = new HashSet<>();
   // private Set<Mark> marks = new HashSet<>();

    public Theme withId(Integer id){
        setId(id);
        return this;
    }

    public Theme withTitle(String title){
        setTitle(title);
        return this;
    }

    @Override
    public String toString() {
        return String.format("Theme [id=%s, title=%s]", getId(), title);
    }
}

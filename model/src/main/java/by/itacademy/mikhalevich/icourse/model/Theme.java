package by.itacademy.mikhalevich.icourse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"title", "groups"})
@EqualsAndHashCode(callSuper = true, exclude = {"title", "groups"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Theme extends AbstractEntity {
    private String title;

    @JsonBackReference
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(name = "theme_class",
            joinColumns = @JoinColumn(name = "theme_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id"))
    private Set<Group> groups = new HashSet<>();

    public Theme withId(Integer id){
        setId(id);
        return this;
    }

    public Theme withTitle(String title){
        setTitle(title);
        return this;
    }

//    @Override
//    public String toString() {
//        return String.format("Theme [id=%s, title=%s]", getId(), title);
//    }
}

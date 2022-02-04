package by.itacademy.mikhalevich.icourse.model.auth;

import by.itacademy.mikhalevich.icourse.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, exclude = {"name"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name="role", schema = "public")
public class Role extends AbstractEntity {
    private String name;

    public Role withId(Integer id){
        setId(id);
        return this;
    }

    public Role withName(String name) {
        setName(name);
        return this;
    }

}

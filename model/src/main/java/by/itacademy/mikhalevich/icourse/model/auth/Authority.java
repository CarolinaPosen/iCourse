package by.itacademy.mikhalevich.icourse.model.auth;

import by.itacademy.mikhalevich.icourse.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, exclude = {"name"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Authority extends AbstractEntity {
    private String name;

    public Authority withId(Integer id){
        setId(id);
        return this;
    }

    public Authority withName(String name) {
        setName(name);
        return this;
    }

}

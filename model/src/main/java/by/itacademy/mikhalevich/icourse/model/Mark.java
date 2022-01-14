package by.itacademy.mikhalevich.icourse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@ToString(callSuper = true, exclude = "student")
@EqualsAndHashCode(callSuper = true, exclude = "student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Mark extends AbstractEntity {
    private int mark;
    private Timestamp date;

    @ManyToOne()
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "student_id")
    private Student student;

    public Mark withId(int id){
        setId(id);
        return this;
    }

    public Mark withMark(int mark){
        setMark(mark);
        return this;
    }

    public Mark withDate(Timestamp date){
        setDate(date);
        return this;
    }

    public Mark withTheme(Theme theme){
        setTheme(theme);
        return this;
    }

//    @Override
//    public String toString() {
//        return String.format("Mark [id=%s, mark=%s, date=%s, theme=%s]", getId(), mark, date, theme);
//    }
}

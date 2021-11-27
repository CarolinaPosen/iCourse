package by.itacademy.mikhalevich.icourse.model;

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
@Entity
public class Mark extends AbstractEntity {
    private int mark;
    private Timestamp date;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @ManyToOne(cascade = {CascadeType.ALL})
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

package by.itacademy.mikhalevich.icourse.model;

import lombok.*;

import java.sql.Timestamp;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mark extends AbstractEntity {
    private int mark;
    private Timestamp date;
    private Theme theme;

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

    @Override
    public String toString() {
        return String.format("Mark [id=%s, mark=%s, date=%s]", getId(), mark, date);
    }
}

package by.itacademy.mikhalevich.icourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mark extends AbstractEntity {
    private int mark;
    private Timestamp date;

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
    @Override
    public String toString() {
        return String.format("Mark [id=%s, mark=%s, date=%s]", getId(), mark, date);
    }
}

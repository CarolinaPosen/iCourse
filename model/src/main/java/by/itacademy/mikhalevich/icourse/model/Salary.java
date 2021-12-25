package by.itacademy.mikhalevich.icourse.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;

@ToString(callSuper = true, exclude = {"trainer"})
@EqualsAndHashCode(callSuper = false, exclude = {"trainer"})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Salary extends AbstractEntity {

    private BigDecimal salary;
    private Timestamp date;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "teacher_id")
    private Trainer trainer;

    public Salary withId(Integer id){
        setId(id);
        return this;
    }

    public Salary withSalary(BigDecimal salary) {
        setSalary(salary);
        return this;
    }

    public Salary withDate(Timestamp date){
        setDate(date);
        return this;
    }

    public Salary withTrainer(Trainer trainer){
        setTrainer(trainer);
        return this;
    }

}

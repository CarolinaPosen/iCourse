package by.itacademy.mikhalevich.icourse.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Salary extends AbstractEntity<Integer> {
    private BigDecimal salary;
    private Timestamp date;
    private Integer trainerId;

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

    public Salary withTrainerId(Integer trainerId){
        setTrainerId(trainerId);
        return this;
    }

}

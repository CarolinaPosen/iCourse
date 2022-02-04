package by.itacademy.mikhalevich.icourse.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.Entity;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, exclude = {"title"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@Entity
public class ExRole extends AbstractEntity{
        private String title;
//        Set<Trainer> trainers = new HashSet<>();

        public ExRole withId(Integer id){
            setId(id);
            return this;
        }

        public ExRole withTitle(String title) {
            setTitle(title);
            return this;
        }

//    public Role addTrainer(Trainer trainer) {
//        trainers.add(trainer);
//        return this;
//    }

    }

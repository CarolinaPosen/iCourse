package by.itacademy.mikhalevich.icourse.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"title"})
@EqualsAndHashCode(callSuper = false, exclude = {"title"})
@Entity
public class Role extends AbstractEntity<Integer>{
        private String title;
//        Set<Trainer> trainers = new HashSet<>();


        public Role withId(Integer id){
            setId(id);
            return this;
        }

        public Role withName(String role) {
            setTitle(role);
            return this;
        }

//    public Role addTrainer(Trainer trainer) {
//        trainers.add(trainer);
//        return this;
//    }

        @Override
        public String toString() {
            return String.format("Role [id=%s, title=%s]", getId(), title);
        }
    }

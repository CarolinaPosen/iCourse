package by.itacademy.mikhalevich.icourse.model.auth;

import by.itacademy.mikhalevich.icourse.model.AbstractEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="role1", schema = "public")
@Data
public class Role1 extends AbstractEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

    private String name;
}

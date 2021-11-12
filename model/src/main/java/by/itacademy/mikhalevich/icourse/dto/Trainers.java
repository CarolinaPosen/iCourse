package by.itacademy.mikhalevich.icourse.dto;

import by.itacademy.mikhalevich.icourse.model.Trainer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainers {
    private String name;
    private List<Trainer> trainerList;
}

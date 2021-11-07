package by.itacademy.mikhalevich.icourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Performance {

    Set<Group> groups = new HashSet<>();
    Set<Student> students = new HashSet<>();
    Set<Theme> themes = new HashSet<>();
    Set<Mark> marks = new HashSet<>();

}

package by.itacademy.mikhalevich.icourse.logic;

import by.itacademy.mikhalevich.icourse.model.Mark;
import by.itacademy.mikhalevich.icourse.model.Salary;

import java.util.Map;
import java.util.Optional;

public interface MarkService {
    Map<Integer, Mark> readMarks();
    Map<Integer, Mark> updateMark(Mark mark);
    Map<Integer, Mark> createMark(Mark mark);
    Map<Integer, Mark> deleteMark(Integer id);
    Mark getMarkById (Integer id);

}

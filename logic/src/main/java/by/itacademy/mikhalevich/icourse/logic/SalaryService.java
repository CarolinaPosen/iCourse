package by.itacademy.mikhalevich.icourse.logic;

import by.itacademy.mikhalevich.icourse.model.Salary;

import java.util.Map;
import java.util.Optional;

public interface SalaryService {
    Map<Integer, Salary> readSalary();
    Map<Integer, Salary> updateSalary(Salary salary);
    Map<Integer, Salary> createSalary(Salary salary);
    Map<Integer, Salary> deleteSalary(Integer id);
    Optional getSalaryById (Integer id);
}

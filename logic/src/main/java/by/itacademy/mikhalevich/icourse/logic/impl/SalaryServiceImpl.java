package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.jdbc.Repository;
import by.itacademy.mikhalevich.icourse.jdbc.SalaryRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.logic.SalaryService;
import by.itacademy.mikhalevich.icourse.model.Salary;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;

public class SalaryServiceImpl implements SalaryService {

    private Repository salaryRepository;

    public SalaryServiceImpl(DataSource dataSource) {
        this.salaryRepository = SalaryRepositoryPostgres.getInstance(dataSource);
    }

    @Override
    public Map<Integer, Salary> readSalary() {
        return salaryRepository.findAll();
    }

    @Override
    public Map<Integer, Salary> updateSalary(Salary salary) {
        salaryRepository.save(salary);
        return null;
    }

    @Override
    public Map<Integer, Salary> createSalary(Salary salary) {
        salaryRepository.save(salary);
        return null;
    }

    @Override
    public Map<Integer, Salary> deleteSalary(Integer id) {
        return null;
    }

    @Override
    public Optional getSalaryById(Integer id) {
        return salaryRepository.find(id);
    }
}

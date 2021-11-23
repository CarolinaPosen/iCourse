package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.jdbc.SalaryRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.logic.SalaryService;
import by.itacademy.mikhalevich.icourse.model.Salary;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class SalaryServiceImpl implements SalaryService {

    public static final int PARAMETER_INDEX = 4;
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
        salaryRepository.save(salary, PARAMETER_INDEX);
        return null;
    }

    @Override
    public Map<Integer, Salary> createSalary(Salary salary) {
        salaryRepository.save(salary, PARAMETER_INDEX);
        return null;
    }

    @Override
    public Map<Integer, Salary> deleteSalary(Integer id) {
        salaryRepository.remove(new Salary().withId(id));
        return null;
    }

    @Override
    public Salary getSalaryById(Integer id) {

        Optional salary = salaryRepository.find(id);

        if (salary.isPresent()) {
            return (Salary) salary.get();
        } else {
            log.error("Salary id: "+ id +" not exists");
            return null;
        }
    }
}

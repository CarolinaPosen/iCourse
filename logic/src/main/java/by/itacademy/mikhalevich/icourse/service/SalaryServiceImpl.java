package by.itacademy.mikhalevich.icourse.service;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.SalaryService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

@Slf4j
public class SalaryServiceImpl implements SalaryService {

    public static final int PARAMETER_INDEX = 4;
    private Repository salaryRepository;
    private Repository trainerRepository;

    public SalaryServiceImpl()  {
        this.salaryRepository = RepositoryFactory.getSalaryRepository();
        this.trainerRepository = RepositoryFactory.getTrainerRepository();
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

        Optional trainer = trainerRepository.find(salary.getTrainer().getId());

        Trainer updateTrainer;
        if(trainer.isPresent()){
            updateTrainer  =  (Trainer) trainer.get();
            updateTrainer.addSalary(salary);
            trainerRepository.save(updateTrainer);
        }
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

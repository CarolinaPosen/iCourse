package by.itacademy.mikhalevich.icours.logic.impl;

import by.itacademy.mikhalevich.icours.logic.StudentService;
import by.itacademy.mikhalevich.icours.model.Student;
import by.itacademy.mikhalevich.icours.repository.ListDataSource;

import java.util.List;

class StudentServiceImpl implements StudentService {

    private ListDataSource dataSource;

    public StudentServiceImpl(ListDataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    public List<Student> listAllStudents() {
        return dataSource.initStudentModel();
    }

}

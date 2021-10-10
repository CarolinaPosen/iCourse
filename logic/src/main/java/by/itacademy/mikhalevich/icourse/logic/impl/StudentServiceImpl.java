package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.logic.StudentService;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.repository.ListDataSource;

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

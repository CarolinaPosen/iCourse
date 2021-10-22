package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.jdbc.StudentRepository;
import by.itacademy.mikhalevich.icourse.logic.StudentService;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.repository.ListDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);

    private ListDataSource dataSource;

    public StudentServiceImpl(ListDataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    public HashMap<Integer, Student> getAllStudents() {

        StudentRepository sr = new StudentRepository();

        return sr.allStudents();

    }



}

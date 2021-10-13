package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.logic.StudentService;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.repository.ListDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);

    private ListDataSource dataSource;

    public StudentServiceImpl(ListDataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    public List<Student> listAllStudents() {
        return null; //dataSource.initStudentModel();
    }

}

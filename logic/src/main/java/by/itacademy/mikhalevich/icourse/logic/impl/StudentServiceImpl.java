package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.jdbc.Repository;
import by.itacademy.mikhalevich.icourse.jdbc.StudentRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.logic.StudentService;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Teacher;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;

class StudentServiceImpl implements StudentService {

    private Repository studentRepository;

    public StudentServiceImpl(DataSource dataSource) {
        this.studentRepository = StudentRepositoryPostgres.getInstance(dataSource);
    }

    @Override
    public Map<Integer, Student> readStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Map<Integer, Student> updateStudent(Student student) {
        return null;
    }

    @Override
    public Map<Integer, Student> createStudent(Student student) {
        return null;
    }

    @Override
    public Map<Integer, Student> deleteStudent(Integer id) {
        return null;
    }

    @Override
    public Optional getStudentById(Integer id) {
        return studentRepository.find(id);
    }


}

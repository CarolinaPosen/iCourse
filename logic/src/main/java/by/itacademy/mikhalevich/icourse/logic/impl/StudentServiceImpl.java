package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.jdbc.MarkRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.jdbc.StudentRepositoryPostgres;
import by.itacademy.mikhalevich.icourse.logic.StudentService;
import by.itacademy.mikhalevich.icourse.model.Student;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;

@Slf4j
class StudentServiceImpl implements StudentService {

    public static final int PARAMETER_INDEX_STUDENT = 5;
    public static final int PARAMETER_INDEX_SALARY = 4;
    private Repository studentRepository;
    private Repository markRepository;

    public StudentServiceImpl(DataSource dataSource) {
        this.studentRepository = StudentRepositoryPostgres.getInstance(dataSource);
        this.markRepository = MarkRepositoryPostgres.getInstance(dataSource);
    }

    @Override
    public Map readStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Map<Integer, Student> updateStudent(Student student) {
        studentRepository.save(student, PARAMETER_INDEX_STUDENT);
        return null;
    }

    @Override
    public Map<Integer, Student> createStudent(Student student) {
        return null;
    }

    @Override
    public Map<Integer, Student> deleteStudent(Integer id) {
        studentRepository.remove(new Student().withId(id));
        return null;
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional student = studentRepository.find(id);

        if (student.isPresent()) {
            return (Student) student.get();
        } else {
            log.error("Trainer id: "+ id +" not exists");
            return null;
        }
    }

//    public Set<Mark> getStudentMarksById(Integer id) {
//        markRepository.
//        return
//    }


}

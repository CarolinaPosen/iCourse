package by.itacademy.mikhalevich.icourse.servicespring;

import by.itacademy.mikhalevich.icourse.*;
import by.itacademy.mikhalevich.icourse.model.ExRole;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Theme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Component("studentServiceSpringImpl")
public class StudentServiceSpringImpl implements StudentService {

    private Repository studentRepository;
    private Repository roleRepository;
    private Repository themeRepository;

    @Autowired
    public StudentServiceSpringImpl(
            @Qualifier("studentRepositoryOrmImpl") StudentRepository studentRepository,
            @Qualifier("roleRepositoryOrmImpl") RoleRepository roleRepository,
            @Qualifier("themeRepositoryOrmImpl") ThemeRepository themeRepository
    ) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
        this.themeRepository = themeRepository;
    }

    @Override
    public Map read() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> update(Student student) {
        return Optional.ofNullable((Student) studentRepository.save(student));
    }

    public Optional<Student> updateStudentsMark(Student student) {
        return Optional.empty();
    }

    @Override
    public Optional<Student> create(Student student) {
        return Optional.ofNullable((Student) studentRepository.save(student));
    }

    @Override
    public Optional<Student> delete(Integer id) {
        Optional<Student> optionalStudent = studentRepository.find(id);
        this.studentRepository.remove(id);
        return optionalStudent;
    }

    @Override
    public Optional<Student> getById(Integer id) {
        Optional student = studentRepository.find(id);
        if (student.isPresent()) {
            return student;
        } else {
            log.error("Student id: "+ id +" not exists");
            return Optional.empty();
        }
    }
}

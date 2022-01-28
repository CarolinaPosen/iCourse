package by.itacademy.mikhalevich.icourse.servicespring;

import by.itacademy.mikhalevich.icourse.*;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.jpa.MarkRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.jpa.RoleRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.jpa.ThemeRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.model.Mark;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Theme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
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
    public Map readStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> updateStudent(Student student) {
        Student updateStudent = (Student) studentRepository.find(student.getId()).get();
        updateStudent.withId(student.getId());
        updateStudent.withName(student.getName());
        updateStudent.withLogin(student.getLogin());
        updateStudent.withPassword(student.getPassword());
        student.getMarks().forEach(mark -> mark.setTheme((Theme) themeRepository.find(mark.getTheme().getId()).get()));
        student.getMarks().forEach(updateStudent::addMark);
        return Optional.ofNullable((Student) studentRepository.save(updateStudent));
    }

    @Override
    public Optional<Student> updateStudentsMark(Student student) {
        return Optional.empty();
    }

    @Override
    public Optional<Student> createStudent(Student student) {
        Role updateRole = (Role) roleRepository.findByName(student.getRole().getTitle()).get();
        student.withRole(updateRole);
        return Optional.ofNullable((Student) studentRepository.save(student));
    }

    @Override
    public Optional<Student> deleteStudent(Integer id) {
        return  studentRepository.remove(id);
    }

    @Override
    public Optional<Student> deleteStudent(Student student) {
        return  studentRepository.remove(student.getId());
    }

    @Override
    public Optional<Student> getStudentById(Integer id) {
        Optional student = studentRepository.find(id);
        if (student.isPresent()) {
            return student;
        } else {
            log.error("Student id: "+ id +" not exists");
            return Optional.empty();
        }
    }
}

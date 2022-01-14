package by.itacademy.mikhalevich.icourse.service;

import by.itacademy.mikhalevich.icourse.StudentService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.jpa.MarkRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.jpa.RoleRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.jpa.ThemeRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Theme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class StudentServiceImpl implements StudentService {

    private Repository studentRepository;
    private Repository roleRepository;
    private Repository markRepository;
    private Repository themeRepository;
    private Repository groupRepository;

    public StudentServiceImpl() {
        this.studentRepository = RepositoryFactory.getStudentRepository();
        this.roleRepository = RepositoryFactory.getRoleRepository();
        this.markRepository = RepositoryFactory.getMarkRepository();
        this.themeRepository = RepositoryFactory.getThemeRepository();
        this.groupRepository = RepositoryFactory.getGroupRepository();
    }

    @Override
    public Map readStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> updateStudent(Student student) {
        return Optional.ofNullable((Student) studentRepository.save(student));
    }

    public Optional<Student> updateStudentsMark(Student student) {
        Student updateStudent = (Student) studentRepository.find(student.getId()).get();
        student.getMarks().forEach(mark -> mark.setTheme((Theme) themeRepository.find(mark.getTheme().getId()).get()));
        student.getMarks().forEach(updateStudent::addMark);
        return Optional.ofNullable((Student) studentRepository.save(updateStudent));
    }

    @Override
    public Optional<Student> createStudent(Student student) {

        int groupId = student.getGroups().stream().findFirst().get().getId();

        Role updateRole = (Role) roleRepository.findByName(student.getRole().getTitle()).get();

        Group updateGroup = (Group) groupRepository.find(groupId).get();
        student.withRole(updateRole);
        updateGroup.addStudent(student);
        groupRepository.save(updateGroup);
        return Optional.empty();
    }

    @Override
    public Optional<Student> deleteStudent(Integer id) {
        return studentRepository.remove(new Student().withId(id));
    }

    @Override
    public Optional<Student> deleteStudent(Student student) {
        return studentRepository.remove(student.getId());
    }

    @Override
    public Optional<Student> getStudentById(Integer id) {
        Optional student = studentRepository.find(id);

        if (student.isPresent()) {
            return student;
        } else {
            log.error("Trainer id: "+ id +" not exists");
            return Optional.empty();
        }
    }

//    public Set<Mark> updateStudentsMarks(Integer id, Integer mark, Timestamp date, Integer studentId) {
//
//        getStudentById(studentId).addMark(new Mark()
//                .withId(id)
//                .withMark(mark)
//                .withDate(date));
//        return
//    }


}

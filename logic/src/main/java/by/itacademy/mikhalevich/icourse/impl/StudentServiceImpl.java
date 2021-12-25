package by.itacademy.mikhalevich.icourse.impl;

import by.itacademy.mikhalevich.icourse.StudentService;
import by.itacademy.mikhalevich.icourse.factory.RepositoryFactory;
import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.jpa.MarkRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.jpa.RoleRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.jpa.ThemeRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

@Slf4j
class StudentServiceImpl implements StudentService {

    private Repository studentRepository;
    private Repository roleRepository;
    private Repository markRepository;
    private Repository themeRepository;

    public StudentServiceImpl() {
        this.studentRepository = RepositoryFactory.getStudentRepository();
        this.roleRepository = RoleRepositoryJpaImpl.getInstance();
        this.markRepository = MarkRepositoryJpaImpl.getInstance();
        this.themeRepository = ThemeRepositoryJpaImpl.getInstance();
    }

    @Override
    public Map readStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Map<Integer, Student> updateStudent(Student student) {

        studentRepository.save(student);
        return null;


    }

    @Override
    public Map<Integer, Student> createStudent(Student student) {
        Role updateRole = (Role) roleRepository.findByName(student.getRole().getTitle()).get();
        student.withRole(updateRole);
        studentRepository.save(student);
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

//    public Set<Mark> updateStudentsMarks(Integer id, Integer mark, Timestamp date, Integer studentId) {
//
//        getStudentById(studentId).addMark(new Mark()
//                .withId(id)
//                .withMark(mark)
//                .withDate(date));
//        return
//    }


}

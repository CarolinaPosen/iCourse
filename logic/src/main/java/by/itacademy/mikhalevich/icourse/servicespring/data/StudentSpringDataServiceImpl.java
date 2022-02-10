package by.itacademy.mikhalevich.icourse.servicespring.data;

import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.spring.data.StudentSpringDataJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("studentSpringDataServiceImpl")
@RequiredArgsConstructor
public class StudentSpringDataServiceImpl implements by.itacademy.mikhalevich.icourse.Service<Student> {

    @Autowired
    private StudentSpringDataJpaRepository repository;


    @Override
    public Map<Integer, Student> read() {
        List<Student> student = repository.findAll();
        return student.stream().collect(Collectors.toMap(Student::getId, Function.identity()));
    }

    @Override
    public Optional<Student> update(Student student) {
        return Optional.ofNullable(repository.save(student));
    }

    @Override
    public Optional<Student> create(Student student) {
        return Optional.ofNullable(repository.save(student));
    }

    @Override
    public Optional<Student> delete(Integer id) {
        Optional<Student> student = repository.findById(id);
        repository.deleteById(id);
        return student;
    }

    @Override
    public Optional<Student> getById(Integer id) {
        return repository.findById(id);
    }
}

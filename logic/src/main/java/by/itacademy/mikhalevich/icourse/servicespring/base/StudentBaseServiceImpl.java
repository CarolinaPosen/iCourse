package by.itacademy.mikhalevich.icourse.servicespring.base;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("studentBaseServiceImpl")
@RequiredArgsConstructor
public class StudentBaseServiceImpl extends BaseServiceImpl<Student> implements by.itacademy.mikhalevich.icourse.Service<Student> {

    @Autowired
    @Qualifier("studentBaseRepositoryImpl")
    private Repository<Student> repository;

    @Override
    protected Repository<Student> getRepository() {
        return repository;
    }
}

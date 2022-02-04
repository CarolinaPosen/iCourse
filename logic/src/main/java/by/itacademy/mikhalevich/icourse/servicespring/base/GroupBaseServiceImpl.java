package by.itacademy.mikhalevich.icourse.servicespring.base;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.model.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("groupBaseServiceImpl")
@RequiredArgsConstructor
public class GroupBaseServiceImpl extends BaseServiceImpl<Group> implements by.itacademy.mikhalevich.icourse.Service<Group> {

    @Autowired
    @Qualifier("groupBaseRepositoryImpl")
    private Repository<Group> repository;

    @Override
    protected Repository<Group> getRepository() {
        return repository;
    }
}

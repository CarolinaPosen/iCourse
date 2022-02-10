package by.itacademy.mikhalevich.icourse.servicespring.data;

import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.spring.data.GroupSpringDataCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("groupSpringDataServiceImpl")
@RequiredArgsConstructor
public class GroupSpringDataServiceImpl implements by.itacademy.mikhalevich.icourse.Service<Group> {

    @Autowired
    private GroupSpringDataCrudRepository repository;

    public Map<Integer, Group> read() {
        List<Group> group = repository.findAll();
        return group.stream().collect(Collectors.toMap(Group::getId, Function.identity()));
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Optional<Group> update(Group group) {
        return Optional.ofNullable(repository.save(group));
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Optional<Group> create(Group group) {
        return Optional.ofNullable(repository.save(group));
    }

    @Transactional(readOnly = false)
    public Optional<Group> delete(Integer id) {
        Optional<Group> removeEntity = repository.findById(id);
        repository.deleteById(id);
        return removeEntity;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Optional<Group> getById(Integer id) {
        return repository.findById(id);
//        return repository.findByTitleStartingWith("A");
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Optional<Group> getById(String name) {
        return repository.findByTitleStartingWith(name);
    }
}

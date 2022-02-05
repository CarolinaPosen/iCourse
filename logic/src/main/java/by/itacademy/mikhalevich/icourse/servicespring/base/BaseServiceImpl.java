package by.itacademy.mikhalevich.icourse.servicespring.base;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.Service;
import by.itacademy.mikhalevich.icourse.model.AbstractEntity;
import by.itacademy.mikhalevich.icourse.spring.AbstractRepositoryOrmImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.TypedQuery;
import java.util.Map;
import java.util.Optional;
@Slf4j
@org.springframework.stereotype.Service("baseServiceImpl")
@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends AbstractEntity> implements Service<T> {

    protected abstract Repository<T> getRepository();

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public Map<Integer, T> read() {
        return getRepository().findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public Optional<T> update(T t) {
        return Optional.ofNullable(getRepository().save(t));
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public Optional<T> create(T t) {
        return Optional.ofNullable(getRepository().save(t));
    }

    @Transactional(readOnly = false)
    @Override
    public Optional<T> delete(Integer id) {
        Optional<T> removeEntity = getRepository().find(id);
        getRepository().remove(id);
        return removeEntity;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public Optional<T> getById(Integer id) {
        return getRepository().find(id);
    }
}

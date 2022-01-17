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
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.TypedQuery;
import java.util.Map;
import java.util.Optional;
@Slf4j
@org.springframework.stereotype.Service("baseServiceImpl")
@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends AbstractEntity> implements Service<T> {

//    @Autowired
//    @Qualifier("baseRepositoryImpl")
//    private Repository<T> repository;

    protected abstract Repository<T> getRepository();

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public Map<Integer, T> read() {
        return transactionTemplate.execute(new TransactionCallback<Map<Integer, T>>() {
            @Override
            public Map<Integer, T> doInTransaction(TransactionStatus transactionStatus) {
                try{
                    return getRepository().findAll();
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                }
                return null;
            }
        });
    }

    @Override
    public Optional<T> update(T t) {
        return Optional.ofNullable(getRepository().save(t));
    }

    @Override
    public Optional<T> create(T t) {
        return Optional.ofNullable(getRepository().save(t));
    }

    @Override
    public Optional<T> delete(T t) {
        return getRepository().remove(t);
    }

    @Override
    public Optional<T> getGroupById(Integer id) {
        return Optional.empty();
    }
}

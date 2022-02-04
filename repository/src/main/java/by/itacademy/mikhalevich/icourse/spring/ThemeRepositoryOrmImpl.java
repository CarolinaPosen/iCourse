package by.itacademy.mikhalevich.icourse.spring;

import by.itacademy.mikhalevich.icourse.ThemeRepository;
import by.itacademy.mikhalevich.icourse.TrainerRepository;
import by.itacademy.mikhalevich.icourse.model.Theme;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository("themeRepositoryOrmImpl")
public class ThemeRepositoryOrmImpl extends AbstractRepositoryOrmImpl<Theme> implements ThemeRepository {

    public ThemeRepositoryOrmImpl(){
        clazz = Theme.class;
    }

    @Override
    protected TypedQuery<Theme> findByNameQuery(String name) {
        return null;
    }
}

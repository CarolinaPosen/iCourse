package by.itacademy.mikhalevich.icourse.service;

import by.itacademy.mikhalevich.icourse.MarkService;
import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.jpa.MarkRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.jpa.ThemeRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.model.Mark;
import by.itacademy.mikhalevich.icourse.model.Theme;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

@Slf4j
public class MarkServiceImpl implements MarkService {
    private Repository markRepository;
    private Repository themeRepository;

    public MarkServiceImpl() {
        this.markRepository = MarkRepositoryJpaImpl.getInstance();
        this.themeRepository = ThemeRepositoryJpaImpl.getInstance();
    }

    @Override
    public Map<Integer, Mark> readMarks() {
        return markRepository.findAll();
    }

    @Override
    public Map<Integer, Mark> updateMark(Mark mark) {
        Theme theme = (Theme) themeRepository.find(mark.getTheme().getId()).get();
        mark.withTheme(theme);
        markRepository.save(mark);
        return null;
    }

    @Override
    public Map<Integer, Mark> createMark(Mark mark) {
        return null;
    }

    @Override
    public Map<Integer, Mark> deleteMark(Integer id) {
        markRepository.remove(id);
        return null;
    }

    @Override
    public Mark getMarkById(Integer id) {
        Optional mark = markRepository.find(id);

        if (mark.isPresent()) {
            return (Mark) mark.get();
        } else {
            log.error("Salary id: "+ id +" not exists");
            return null;
        }
    }
}

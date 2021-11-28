package by.itacademy.mikhalevich.icourse.logic.impl;

import by.itacademy.mikhalevich.icourse.Repository;
import by.itacademy.mikhalevich.icourse.jpa.MarkRepositoryJpaImpl;
import by.itacademy.mikhalevich.icourse.logic.MarkService;
import by.itacademy.mikhalevich.icourse.model.Mark;
import by.itacademy.mikhalevich.icourse.model.Salary;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

@Slf4j
public class MarkServiceImpl implements MarkService {
    private Repository markRepository;

    public MarkServiceImpl() {
        this.markRepository = MarkRepositoryJpaImpl.getInstance();
    }

    @Override
    public Map<Integer, Mark> readMarks() {
        return markRepository.findAll();
    }

    @Override
    public Map<Integer, Mark> updateMark(Mark mark) {
        markRepository.save(mark);
        return null;
    }

    @Override
    public Map<Integer, Mark> createMark(Mark mark) {
        return null;
    }

    @Override
    public Map<Integer, Mark> deleteMark(Integer id) {
        markRepository.remove(new Mark().withId(id));
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

package by.itacademy.mikhalevich.icourse.logic.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import by.itacademy.mikhalevich.icourse.logic.TeacherService;
import by.itacademy.mikhalevich.icourse.logic.calculating.Accounting;
import by.itacademy.mikhalevich.icourse.logic.exception.LogicalServerErrorException;
import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.repository.ListDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TeacherServiceImpl implements TeacherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);

    private ListDataSource dataSource;
    private long incrementId = 99;

    public TeacherServiceImpl() {
    }

    public TeacherServiceImpl(ListDataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    public Map<Integer, Teacher> readTeachers() {
        return getSortedTeachers(dataSource.getTeachersMap());
    }

    @Override
    public Map<Integer, Teacher> updateTeacher(Teacher teacher) {
        if (teacher==null || teacher.getName().isEmpty()) {
            LOGGER.error("Can't update teacher");
            throw new LogicalServerErrorException("Can't update teacher");
        }else{
            LOGGER.info("Update teachers attribute " + teacher);
            return getSortedTeachers(dataSource.updateTeacher(teacher));
        }
    }

    @Override
    public Map<Integer, Teacher> createTeacher(Teacher teacher) {
        incrementId++;
        teacher.setId(incrementId);
        LOGGER.info("Create new teacher " + teacher);
        return getSortedTeachers(dataSource.createTeacher(teacher));
    }

    @Override
    public Map<Integer, Teacher> deleteTeacher(Integer id) {
        LOGGER.info("Delete teacher " + dataSource.getTeacherById(id));
        return dataSource.deleteTeacher(id);
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return dataSource.getTeacherById(id);
    }

    @Override
    public BigDecimal averageSalary(Integer id, int countOfMonth) {
        BigDecimal averageSalary = Accounting.average(dataSource.getTeacherById(id).getSalary(), countOfMonth).setScale(2, RoundingMode.HALF_UP);
        LOGGER.info("Accounting teachers {} average salary {}", dataSource.getTeacherById(id).getName(), averageSalary);
        return averageSalary;
    }

    private Map<Integer, Teacher> getSortedTeachers(Map<Integer, Teacher> teachers) {
        Map<Integer, Teacher> result = teachers.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }


}

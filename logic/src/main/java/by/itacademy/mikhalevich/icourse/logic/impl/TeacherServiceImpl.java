package by.itacademy.mikhalevich.icourse.logic.impl;

class TeacherServiceImpl {

 /*   private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);

    private ListDataSource dataSource;
    private long incrementId = 99;

    public TeacherServiceImpl() {
    }

    @Override
    public Map<Integer, Trainer> readTeachers() {
        return getSortedTeachers(dataSource.getTeachersMap());
    }

    @Override
    public Map<Integer, Teacher> updateTeacher(Teacher teacher) {
        if (teacher == null || teacher.getName().isEmpty()) {
            LOGGER.error("Can't update teacher");
            throw new LogicalServerErrorException("Can't update teacher");
        } else {
            LOGGER.info("Update teachers attribute " + teacher);
            return getSortedTeachers(dataSource.updateTeacher(teacher));
        }
    }

    @Override
    public Map<Integer, Trainer> createTeacher(Trainer teacher) {
        incrementId++;
        teacher.setId(incrementId);
        LOGGER.info("Create new teacher " + teacher);
        return getSortedTeachers(dataSource.createTeacher(teacher));
    }

    @Override
    public Map<Integer, Trainer> deleteTeacher(Integer id) {
        LOGGER.info("Delete teacher " + dataSource.getTeacherById(id));
        return dataSource.deleteTeacher(id);
    }

    @Override
    public Trainer getTeacherById(Integer id) {
        return dataSource.getTeacherById(id);
    }

    @Override
    public BigDecimal averageSalary(Integer id, int countOfMonth) {
        BigDecimal averageSalary = Accounting.average(dataSource.getTeacherById(id).getSalary(), countOfMonth).setScale(2, RoundingMode.HALF_UP);
        LOGGER.info("Accounting teachers {} average salary {}", dataSource.getTeacherById(id).getName(), averageSalary);
        return averageSalary;
    }

    private Map<Integer, Trainer> getSortedTeachers(Map<Integer, Trainer> teachers) {
        Map<Integer, Trainer> result = teachers.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return result;
    }*/


}

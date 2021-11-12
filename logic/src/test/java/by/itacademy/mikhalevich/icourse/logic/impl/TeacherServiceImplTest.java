package by.itacademy.mikhalevich.icourse.logic.impl;

public class TeacherServiceImplTest {

/*    private ListDataSource dataSource = new ListDataSource();
    private TeacherServiceImpl service = new TeacherServiceImpl();
    private Map<Integer, Teacher> teacherList = service.readTeachers();

    @Before
    public void setUp() {
        teacherList.put(1, new Teacher(1, "John", 30, List.of(10, 22, 36, 48, 54, 61, 75, 88, 97, 160, 211, 112)));
        teacherList.put(2, new Teacher(2, "Petr", 23, List.of(12, 255, 35, 444, 555, 64, 73, 86, 55, 1503, 415, 112)));
        teacherList.put(3, new Teacher(3, "Ivan", 16, List.of(15, 25, 36, 425, 525, 645, 722, 885, 988, 105, 151, 122)));
        teacherList.put(4, new Teacher(4, "Santa", 35, List.of(12, 22, 32, 42, 52, 62, 72, 82, 92, 105, 115, 1255)));
        teacherList.put(5, new Teacher(5, "Eli", 23, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        teacherList.put(6, new Teacher(6, "MARS", 88, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        teacherList.put(7, new Teacher(7, "Mr.Proper", 20, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        teacherList.put(8, new Teacher(8, "Smith", 18, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        teacherList.put(9, new Teacher(9, "Nikolai", 45, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        teacherList.put(10, new Teacher(10, "Jo", 43, List.of(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12)));
    }

    @Test
    public void readTeachers() {
        Map<Integer, Teacher> expected = teacherList;
        Map<Integer, Teacher> actual = service.readTeachers();
        assertEquals("Read teachers",expected, actual);
    }

    @Test
    public void updateTeacher() {
        Integer teacherId = 1;
        String expectedName = "TestUserUpdate";
        int expectedAge = 99;
        List<Integer> expectedSalary = new ArrayList<>(List.of(11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0));

        Teacher teacher =
                new Teacher(teacherId, expectedName, expectedAge, expectedSalary);

        Teacher actual = service.getTeacherById(teacherId);
        service.updateTeacher(teacher);
        Teacher expected = service.getTeacherById(teacherId);

        assertNotNull(expected);
        assertSame(expected.getId(),actual.getId());
        assertNotSame(expected, actual);
        assertEquals(expected.getAge(), expectedAge);
        assertEquals(expected.getSalary(), expectedSalary);
    }

    @Test(expected= LogicalServerErrorException.class)
    public void updateTeacherCatchException() {
        service.updateTeacher(null);
    }

    @Test
    public void createTeacher() {
    }

    @Test
    public void deleteTeacher() {
    }*/
}
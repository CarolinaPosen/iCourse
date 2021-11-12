package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.model.Mark;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Theme;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class StudentRepositoryPostgres extends AbstractRepository<Student> {
    //language=PostgreSQL
    private static final String SELECT_FROM_STUDENT_ALL_FIELDS =
            "select s.id id, s.name title, s.login log, s.password pass, s.role_id role_id, m.id mark_id, m.mark mark, th.id theme_id, th.title theme_title" +
                    " from student s " +
                    " join student_class sc on s.id = sc.student_id " +
                    " join class c on sc.class_id = c.id " +
                    " join theme_class tc on c.id = tc.class_id " +
                    " join theme th on tc.theme_id = th.id " +
                    " join mark m on s.id = m.student_id ";

    //language=PostgreSQL
    private static final String ONE_ENTITY_FILTER = " where s.id = ?";
    private static final String FIND_STUDENT_BY_ID = SELECT_FROM_STUDENT_ALL_FIELDS + ONE_ENTITY_FILTER;

    //language=PostgreSQL
    private static final String INSERT_STUDENT_SQL = "insert into student (name, login) values (?, ?) returning id";

    //language=PostgreSQL
    private static final String UPDATE_STUDENT_SQL = "update student s set name = ?, login = ?, password = ?, role_id = ? " + ONE_ENTITY_FILTER;

    //language=PostgreSQL
    private static final String DELETE_STUDENT_BY_ID = "delete from student s" + ONE_ENTITY_FILTER;

    private static volatile StudentRepositoryPostgres instance;

    private StudentRepositoryPostgres(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static StudentRepositoryPostgres getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (TeacherRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new StudentRepositoryPostgres(dataSource);
                }
            }
        }
        return instance;
    }

    @Override
    protected String selectAllFields() {
        return SELECT_FROM_STUDENT_ALL_FIELDS;
    }

    @Override
    protected String findById() {
        return FIND_STUDENT_BY_ID;
    }

    @Override
    protected String insertSql() {
        return INSERT_STUDENT_SQL;
    }

    @Override
    protected String updateSql() {
        return UPDATE_STUDENT_SQL;
    }

    @Override
    protected String deleteSql() {
        return DELETE_STUDENT_BY_ID;
    }

    public void insertLogic(Student student, PreparedStatement ps) throws SQLException {
        ps.setString(1, student.getName());
        ps.setString(2, student.getLogin());
        ps.setString(3, student.getPassword());
        ps.setInt(4, student.getRole().getId());
    }

    public void updateLogic(Student student, PreparedStatement ps) throws SQLException {
        ps.setString(1, student.getName());
        ps.setString(2, student.getLogin());
        ps.setString(3, student.getPassword());
        ps.setInt(4, student.getRole().getId());
    }

    @Override
    public Map<Integer, Student> resultSetToEntities(ResultSet rs) throws SQLException {
        Map<Integer, Student> studentMap = new LinkedHashMap<>();
        while (rs.next()) {
            int sId = rs.getInt("id");
            int mId = rs.getInt("mark_id");
            int thId = rs.getInt("theme_id");
            studentMap.putIfAbsent(sId, new Student()
                    .withId(sId)
                    .withName(rs.getString("title"))
                    .withLogin(rs.getString("log"))
                    .withPassword(rs.getString("pass"))
                    .withRole(new Role()
                            .withId(rs.getInt("role_id"))
                            .withName("Role")));

            studentMap.get(sId).addMark(new Mark()
                    .withId(mId)
                    .withMark(rs.getInt("mark"))
                    .withDate(Timestamp.valueOf(LocalDateTime.now()))
                    .withTheme(new Theme()
                            .withId(thId)
                            .withTitle(rs.getString("theme_title"))));

        }
        return studentMap;
    }
}


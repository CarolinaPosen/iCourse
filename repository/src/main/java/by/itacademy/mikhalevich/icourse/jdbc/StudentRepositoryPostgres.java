package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.model.Student;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class StudentRepositoryPostgres extends AbstractRepository<Student> {
    //language=PostgreSQL
    private static final String SELECT_FROM_STUDENT_ALL_FIELDS =
            "select s.id id, s.name title, s.login log, s.password pass, s.role_id role_id," +
                    " stg.student_mark mark, stg.theme_id theme_id "+
                    " from student s " +
                    " join student_theme_group stg" +
                    " on s.id = stg.student_id";
    //language=SQL
    private static final String ONE_ENTITY_FILTER = " where t.id = ?";
    private static final String FIND_EMPLOYEE_BY_ID = SELECT_FROM_STUDENT_ALL_FIELDS + ONE_ENTITY_FILTER;
    //language=SQL
    private static final String INSERT_EMPLOYEE_SQL = "insert into teacher (name, login) values (?, ?) returning id";
    //language=SQL
    private static final String UPDATE_EMPLOYEE_SQL = "update teacher t set name = ?, login = ?" + ONE_ENTITY_FILTER;
    //language=SQL
    private static final String DELETE_EMPLOYEE_BY_ID = "delete from teacher t" + ONE_ENTITY_FILTER;

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
        return FIND_EMPLOYEE_BY_ID;
    }

    @Override
    protected String insertSql() {
        return INSERT_EMPLOYEE_SQL;
    }

    @Override
    protected String updateSql() {
        return UPDATE_EMPLOYEE_SQL;
    }

    @Override
    protected String deleteSql() {
        return DELETE_EMPLOYEE_BY_ID;
    }

    public void insertLogic(Student student, PreparedStatement ps) throws SQLException {
        ps.setString(1, student.getName());
        ps.setString(2, student.getLogin());
    }

    public void updateLogic(Student student, PreparedStatement ps) throws SQLException {
        ps.setString(1, student.getName());
        ps.setString(2, student.getLogin());
    }

    @Override
    public Map<Integer, Student> resultSetToEntities(ResultSet rs) throws SQLException {
        Map<Integer, Student> studentMap = new LinkedHashMap<>();
        while (rs.next()) {
            int sId = rs.getInt("id");
            studentMap.putIfAbsent(sId, new Student()
                    .withId(sId)
                    .withName(rs.getString("title"))
                    .withLogin(rs.getString("log"))
                    .withPassword(rs.getString("pass"))
                    .withRole(rs.getInt("role_id")));

            studentMap.get(sId).addMark(rs.getInt("theme_id"), rs.getInt("mark"));

        }
        return studentMap;
    }
}


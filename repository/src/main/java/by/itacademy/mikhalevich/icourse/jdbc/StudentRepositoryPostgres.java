package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.model.*;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class StudentRepositoryPostgres extends AbstractRepository<Student> {
    //language=PostgreSQL
    private static final String SELECT_FROM_STUDENT_ALL_FIELDS =
            "select s.id id, s.name title, s.login log, s.password pass, s.role_id role_id," +
                    " m.id mark_id, m.mark mark, m.date mark_date, m.theme_id theme_id," +
                    " th.title theme_title" +
                    " from student s " +
                    " left join mark m on s.id = m.student_id "+
                    " join theme th on m.theme_id = th.id " ;


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

            Map<Integer, Mark> markMap = new HashMap<>();

            studentMap.putIfAbsent(sId, new Student()
                    .withId(sId)
                    .withName(rs.getString("title"))
                    .withLogin(rs.getString("log"))
                    .withPassword(rs.getString("pass"))
                    .withRole(new Role()
                            .withId(rs.getInt("role_id"))
                            .withTitle("Role"))
                    .addMark(putIfAbsentAndReturn(markMap, mId,
                            new Mark()
                                    .withId(mId)
                                    .withDate(rs.getTimestamp("mark_date"))
                                    .withMark(rs.getInt("mark")))
                                    .withTheme(new Theme()
                                            .withId(thId)
                                            .withTitle(rs.getString("theme_title")))));

//            studentMap.get(sId).addMark(new Mark()
//                    .withId(mId)
//                    .withMark(rs.getInt("mark"))
//                    .withDate(Timestamp.valueOf(LocalDateTime.now()))
//                    .withTheme(new Theme()
//                            .withId(thId)
//                            .withTitle(rs.getString("theme_title"))));

            studentMap.computeIfPresent(sId, (id, student) -> student.addMark(markMap.get(mId)));
//            trainersMap.computeIfPresent(tId, (id, trainer) -> trainer.addSalary(salaryMap.get(sId)));

        }
        return studentMap;
    }
}


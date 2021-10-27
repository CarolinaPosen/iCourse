package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.model.Trainer;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Slf4j
public class TeacherRepositoryPostgres extends AbstractRepository<Trainer> {
    //language=SQL
    private static final String SELECT_FROM_TRAINERS_ALL_FIELDS =
            "select t.id id, t.name title, t.login log, t.password pass, t.role_id role_id," +
                    " s.id salary_id, s.salary salary, s.date salary_date " +
                    " from teacher t " +
                    " join salary s " +
                    " on s.id = s.teacher_id ";
    //language=SQL
    private static final String ONE_ENTITY_FILTER = " where t.id = ?";
    private static final String FIND_EMPLOYEE_BY_ID = SELECT_FROM_TRAINERS_ALL_FIELDS + ONE_ENTITY_FILTER;
    //language=SQL
    private static final String INSERT_EMPLOYEE_SQL = "insert into teacher (name, login) values (?, ?) returning id";
    //language=SQL
    private static final String UPDATE_EMPLOYEE_SQL = "update teacher t set name = ?, login = ?" + ONE_ENTITY_FILTER;
    //language=SQL
    private static final String DELETE_EMPLOYEE_BY_ID = "delete from teacher t" + ONE_ENTITY_FILTER;

    private static volatile TeacherRepositoryPostgres instance;

    private TeacherRepositoryPostgres(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static TeacherRepositoryPostgres getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (TeacherRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new TeacherRepositoryPostgres(dataSource);
                }
            }
        }
        return instance;
    }

    @Override
    protected String selectAllFields() {
        return SELECT_FROM_TRAINERS_ALL_FIELDS;
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

    public void insertLogic(Trainer trainer, PreparedStatement ps) throws SQLException {
        ps.setString(1, trainer.getName());
        ps.setString(2, trainer.getLogin());
    }

    public void updateLogic(Trainer trainer, PreparedStatement ps) throws SQLException {
        ps.setString(1, trainer.getName());
        ps.setString(2, trainer.getLogin());
    }

    @Override
    public Map<Integer, Trainer> resultSetToEntities(ResultSet rs) throws SQLException {
        Map<Integer, Trainer> trainersMap = new LinkedHashMap<>();
        while (rs.next()) {
            int tId = rs.getInt("id");
            trainersMap.putIfAbsent(tId, new Trainer()
                    .withId(tId)
                    .withName(rs.getString("title"))
                    .withLogin(rs.getString("log"))
                    .withPassword(rs.getString("pass"))
                    .withRole(rs.getInt("role_id")));

            trainersMap.get(tId).addSalary(rs.getInt("salary_id"), rs.getInt("salary"));

        }
        return trainersMap;
    }
}
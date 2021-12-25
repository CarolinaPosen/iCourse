package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.SalaryRepository;
import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class SalaryRepositoryPostgres extends AbstractRepository<Salary> implements SalaryRepository {

    //language=PostgreSQL
    private static final String SELECT_FROM_SALARY_ALL_FIELDS =
            "select s.id id, s.salary salary, s.date salary_date, s.teacher_id teacher_id " +
                    " from salary s ";
    //language=PostgreSQL
    private static final String ONE_ENTITY_FILTER = " where s.id = ?";
    private static final String FIND_SALARY_BY_ID = SELECT_FROM_SALARY_ALL_FIELDS + ONE_ENTITY_FILTER;
    //language=PostgreSQL
    private static final String INSERT_SALARY_SQL = "insert into salary (salary, date, teacher_id) values (?, ?, ?) returning id";
    //language=PostgreSQL
    private static final String UPDATE_SALARY_SQL = "update salary s set salary = ?, date = ?, teacher_id = ? " + ONE_ENTITY_FILTER;
    //language=PostgreSQL
    private static final String DELETE_SALARY_BY_ID = "delete from salary s" + ONE_ENTITY_FILTER;


    private static volatile SalaryRepositoryPostgres instance;

    private SalaryRepositoryPostgres(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static SalaryRepositoryPostgres getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (SalaryRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new SalaryRepositoryPostgres(dataSource);
                }
            }
        }
        return instance;
    }

    @Override
    protected String selectAllFields() {
        return SELECT_FROM_SALARY_ALL_FIELDS;
    }

    @Override
    protected String findById() {
        return FIND_SALARY_BY_ID;
    }

    @Override
    protected String insertSql() {
        return INSERT_SALARY_SQL;
    }

    @Override
    protected String updateSql() {
        return UPDATE_SALARY_SQL;
    }

    @Override
    protected String deleteSql() {
        return DELETE_SALARY_BY_ID;
    }

    public void insertLogic(Salary salary, PreparedStatement ps) throws SQLException {
        ps.setBigDecimal(1, salary.getSalary());
        ps.setTimestamp(2, salary.getDate());
    }

    public void updateLogic(Salary salary, PreparedStatement ps) throws SQLException {
        ps.setBigDecimal(1, salary.getSalary());
        ps.setTimestamp(2, salary.getDate());
        ps.setInt(3, salary.getTrainer().getId());
    }

    @Override
    public Map<Integer, Salary> resultSetToEntities(ResultSet rs) throws SQLException {
        Map<Integer, Salary> salaryMap = new LinkedHashMap<>();
        while (rs.next()) {
            int tId = rs.getInt("id");
            salaryMap.putIfAbsent(tId, new Salary()
                    .withId(tId)
                    .withSalary(rs.getBigDecimal("salary"))
                    .withDate(rs.getTimestamp("salary_date")));
        }
        return salaryMap;
    }

    @Override
    public Optional<Salary> findByName(String name) {
        return Optional.empty();
    }
}

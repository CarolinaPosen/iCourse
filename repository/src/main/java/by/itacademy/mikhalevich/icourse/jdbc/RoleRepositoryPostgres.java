package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.RoleRepository;
import by.itacademy.mikhalevich.icourse.SalaryRepository;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Salary;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class RoleRepositoryPostgres extends AbstractRepository<Role> implements RoleRepository {

    //language=PostgreSQL
    private static final String SELECT_FROM_ROLE_ALL_FIELDS =
            "select r.id id, r.title title " +
                    " from role r ";
    //language=PostgreSQL
    private static final String ONE_ENTITY_FILTER = " where r.id = ?";
    private static final String FIND_ROLE_BY_ID = SELECT_FROM_ROLE_ALL_FIELDS + ONE_ENTITY_FILTER;
    //language=PostgreSQL
    private static final String INSERT_ROLE_SQL = "insert into role (title) values (?) returning id";
    //language=PostgreSQL
    private static final String UPDATE_ROLE_SQL = "update role r set title = ? " + ONE_ENTITY_FILTER;
    //language=PostgreSQL
    private static final String DELETE_ROLE_BY_ID = "delete from role r" + ONE_ENTITY_FILTER;


    private static volatile RoleRepositoryPostgres instance;

    private RoleRepositoryPostgres(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static RoleRepositoryPostgres getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (RoleRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new RoleRepositoryPostgres(dataSource);
                }
            }
        }
        return instance;
    }

    @Override
    protected String selectAllFields() {
        return SELECT_FROM_ROLE_ALL_FIELDS;
    }

    @Override
    protected String findById() {
        return FIND_ROLE_BY_ID;
    }

    @Override
    protected String insertSql() {
        return INSERT_ROLE_SQL;
    }

    @Override
    protected String updateSql() {
        return UPDATE_ROLE_SQL;
    }

    @Override
    protected String deleteSql() {
        return DELETE_ROLE_BY_ID;
    }

    public void insertLogic(Role role, PreparedStatement ps) throws SQLException {
        ps.setString(1, role.getTitle());
    }

    public void updateLogic(Role role, PreparedStatement ps) throws SQLException {
        ps.setString(1, role.getTitle());
    }

    @Override
    public Map<Integer, Role> resultSetToEntities(ResultSet rs) throws SQLException {
        Map<Integer, Role> roleMap = new LinkedHashMap<>();
        while (rs.next()) {
            int rId = rs.getInt("id");
            roleMap.putIfAbsent(rId, new Role()
                    .withId(rId)
                    .withTitle(rs.getString("title")));
        }
        return roleMap;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return Optional.empty();
    }
}
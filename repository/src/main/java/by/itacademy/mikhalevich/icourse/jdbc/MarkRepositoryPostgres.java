package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.MarkRepository;
import by.itacademy.mikhalevich.icourse.model.Mark;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class MarkRepositoryPostgres extends AbstractRepository<Mark> implements MarkRepository {

    //language=PostgreSQL
    private static final String SELECT_FROM_MARK_ALL_FIELDS =
            "select m.id id, m.mark mark, m.date date, m.student_id student_id " +
                    " from mark m ";
    //language=PostgreSQL
    private static final String ONE_ENTITY_FILTER = " where m.id = ?";
    private static final String FIND_MARK_BY_ID = SELECT_FROM_MARK_ALL_FIELDS + ONE_ENTITY_FILTER;
    //language=PostgreSQL
    private static final String INSERT_MARK_SQL = "insert into mark (mark, date, student_id) values (?, ?, ?) returning id";
    //language=PostgreSQL
    private static final String UPDATE_MARK_SQL = "update mark m set mark = ?, date = ?, student_id = ? " + ONE_ENTITY_FILTER;
    //language=PostgreSQL
    private static final String DELETE_MARK_BY_ID = "delete from mark m" + ONE_ENTITY_FILTER;

    private static volatile MarkRepositoryPostgres instance;

    private MarkRepositoryPostgres(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static MarkRepositoryPostgres getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (MarkRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new MarkRepositoryPostgres(dataSource);
                }
            }
        }
        return instance;
    }

    @Override
    protected String selectAllFields() {
        return SELECT_FROM_MARK_ALL_FIELDS;
    }

    @Override
    protected String findById() {
        return FIND_MARK_BY_ID;
    }

    @Override
    protected String insertSql() {
        return INSERT_MARK_SQL;
    }

    @Override
    protected String updateSql() {
        return UPDATE_MARK_SQL;
    }

    @Override
    protected String deleteSql() {
        return DELETE_MARK_BY_ID;
    }

    @Override
    public Map<Integer, Mark> resultSetToEntities(ResultSet rs) throws SQLException {
        Map<Integer, Mark> markMap = new LinkedHashMap<>();
        while (rs.next()) {
            int tId = rs.getInt("id");
            markMap.putIfAbsent(tId, new Mark()
                    .withId(tId)
                    .withDate(rs.getTimestamp("date")));
        }
        return markMap;
    }

    @Override
    protected void insertLogic(Mark entity, PreparedStatement ps) throws SQLException {
        ps.setInt(1, entity.getMark());
        ps.setTimestamp(2, entity.getDate());
        ps.setInt(3, (int) entity.getTheme().getId());
    }

    @Override
    protected void updateLogic(Mark entity, PreparedStatement ps) throws SQLException {
        ps.setInt(1, entity.getMark());
        ps.setTimestamp(2, entity.getDate());
        ps.setInt(3, (int) entity.getTheme().getId());
    }

    @Override
    public Optional<Mark> findByName(String name) {
        return Optional.empty();
    }
}


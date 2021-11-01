package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Teacher;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class GroupRepositoryPostgres extends AbstractRepository<Group> {

    public static final String G_ID = "g_id";
    public static final String S_ID = "s_id";
    public static final String TH_ID = "th_id";
    public static final String T_ID = "t_id";
    public static final String TITLE = "title";
    public static final String T_NAME = "t_name";
    public static final String LOGIN = "log";
    public static final String PASSWORD = "pass";
    public static final String ROLE_ID = "role_id";
    public static final String THEME_TITLE = "theme_title";
    //language=PostgreSQL
    private static final String SELECT_FROM_GROUP_ALL_FIELDS =
            "select c.id g_id, c.title title," +
                    " s.id s_id, s.name title, s.login log, s.password pass, s.role_id role_id," +
                    " th.id th_id, th.title theme_title," +
                    " t.id t_id, t.name t_name, t.login t_login" +
                    " from class c" +
                    " join student_theme_group stg" +
                    " on c.id = stg.group_id" +
                    " join student s " +
                    " on stg.student_id = s.id" +
                    " join theme th " +
                    " on stg.theme_id = th.id" +
                    " join teacher t " +
                    " on c.teacher_id = t.id";
    //language=PostgreSQL
    private static final String ONE_ENTITY_FILTER = " where c.id = ? ";
    //language=PostgreSQL
    public static final String FIND_GROUP_BY_ID = SELECT_FROM_GROUP_ALL_FIELDS + ONE_ENTITY_FILTER;

    private static final String INSERT_GROUP_SQL = "insert into class (title) values (?) returning id";

    //language=PostgreSQL
    private static final String UPDATE_GROUP_SQL = "update class c set title = ?" + ONE_ENTITY_FILTER;

    //language=PostgreSQL
    private static final String DELETE_GROUP_BY_ID = "delete from class c" + ONE_ENTITY_FILTER;

    private static volatile GroupRepositoryPostgres instance;

    private GroupRepositoryPostgres(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static GroupRepositoryPostgres getInstance(DataSource dataSource) {
        if (instance == null) {
            synchronized (GroupRepositoryPostgres.class) {
                if (instance == null) {
                    instance = new GroupRepositoryPostgres(dataSource);
                }
            }
        }
        return instance;
    }

    @Override
    protected String selectAllFields() {
        return SELECT_FROM_GROUP_ALL_FIELDS;
    }

    @Override
    protected String findById() {
        return FIND_GROUP_BY_ID;
    }

    @Override
    protected String insertSql() {
        return INSERT_GROUP_SQL;
    }

    @Override
    protected String updateSql() {
        return UPDATE_GROUP_SQL;
    }

    @Override
    protected String deleteSql() {
        return DELETE_GROUP_BY_ID;
    }

    public void insertLogic(Group group, PreparedStatement ps) throws SQLException {
        ps.setString(1, group.getTitle());
    }

    public void updateLogic(Group group, PreparedStatement ps) throws SQLException {
        ps.setString(1, group.getTitle());
    }

    @Override
    public Map<Integer, Group> resultSetToEntities(ResultSet rs) throws SQLException {
        Map<Integer, Group> groupMap = new LinkedHashMap<>();
        while (rs.next()) {

            Integer gId = rs.getInt(G_ID);
            Integer sId = rs.getInt(S_ID);
            Integer thId = rs.getInt(TH_ID);
            Integer tId = rs.getInt(T_ID);

            HashMap<Integer, Student> studentsMap = new HashMap<>();
            HashMap<Integer, String> themesMap = new HashMap<>();

            groupMap.putIfAbsent(gId, new Group()
                    .withId(gId)
                    .withTitle(rs.getString(TITLE))
                    .withTeacher(new Teacher(tId, rs.getString(T_NAME), 30, List.of(new Salary())))
                    .addStudent(sId, putIfAbsentAndReturn(studentsMap, sId,
                            new Student()
                                    .withId(sId)
                                    .withName(rs.getString(TITLE))
                                    .withLogin(rs.getString(LOGIN))
                                    .withPassword(rs.getString(PASSWORD))
                                    .withRole(rs.getInt(ROLE_ID))))
                    .addTheme(thId, putIfAbsentAndReturn(themesMap, thId, rs.getString(THEME_TITLE))));

            groupMap.computeIfPresent(gId, (id, groups)->groups.addTheme(thId, themesMap.get(thId)));
            groupMap.computeIfPresent(gId, (id, groups)->groups.addStudent(sId, studentsMap.get(sId)));

        }
        return groupMap;
    }
}
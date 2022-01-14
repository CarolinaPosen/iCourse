package by.itacademy.mikhalevich.icourse.spring;

import by.itacademy.mikhalevich.icourse.GroupRepository;
import by.itacademy.mikhalevich.icourse.model.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component("groupRepositoryTemplateImpl")
@RequiredArgsConstructor
public class GroupRepositoryTemplateImpl implements GroupRepository {

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
    public static final String S_NAME = "s_name";
    //language=PostgreSQL
    private static final String SELECT_FROM_GROUP_ALL_FIELDS =
            "select c.id g_id, c.title title," +
                    " s.id s_id, s.name " + S_NAME + ", s.login log, s.password pass, s.role_id role_id," +
                    " th.id th_id, th.title theme_title," +
                    " t.id t_id, t.name t_name, t.login t_login" +
                    " from class c" +
                    " LEFT OUTER join theme_class thc" +
                    " on c.id = thc.class_id" +
                    " LEFT OUTER join theme th " +
                    " on th.id = thc.theme_id" +
                    " join teacher t " +
                    " on c.teacher_id = t.id" +
                    " join student_class sc " +
                    " on sc.class_id = c.id" +
                    " join student s " +
                    " on sc.student_id = s.id";

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Group> groupRowMapper = (rs, i) -> new Group()
            .withId(rs.getInt(G_ID))
            .withTitle(rs.getString(TITLE));

    @Override
    public Map<Integer, Group> findAll() {
        List<Group> group = jdbcTemplate.query(SELECT_FROM_GROUP_ALL_FIELDS, groupRowMapper);
        return group.stream().collect(Collectors.toMap(Group::getId, Function.identity()));
    }



    @Override
    public Optional<Group> find(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Group> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Group save(Group entity) {
        return null;
    }

    @Override
    public Optional<Group> remove(Group entity) {
        return Optional.empty();
    }
}

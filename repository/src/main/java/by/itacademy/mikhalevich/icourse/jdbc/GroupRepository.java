package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class GroupRepository extends AbstractConnection {

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

    public HashMap<Integer, Group> getAllGroups() {
        HashMap<Integer, Group> groupsMap = new HashMap<>();

        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement(SELECT_FROM_GROUP_ALL_FIELDS);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Integer gId = rs.getInt(G_ID);
                Integer sId = rs.getInt(S_ID);
                Integer thId = rs.getInt(TH_ID);
                Integer tId = rs.getInt(T_ID);

                HashMap<Integer, Student> studentsMap = new HashMap<>();
                HashMap<Integer, String> themesMap = new HashMap<>();

                groupsMap.putIfAbsent(gId, new Group()
                        .withId(gId)
                        .withTitle(rs.getString(TITLE))
                        .withTeacher(new Teacher(tId, rs.getString(T_NAME), 30, List.of(10, 22, 36, 48, 54, 61, 75, 88, 97, 160, 211, 112)))
                .addStudent(sId, putIfAbsentAndReturn(studentsMap, sId,
                        new Student()
                                .withId(sId)
                                .withName(rs.getString(TITLE))
                                .withLogin(rs.getString(LOGIN))
                                .withPassword(rs.getString(PASSWORD))
                                .withRole(rs.getInt(ROLE_ID))))
                .addTheme(thId, putIfAbsentAndReturn(themesMap, thId, rs.getString(THEME_TITLE))));

                groupsMap.computeIfPresent(gId, (id, groups)->groups.addTheme(thId, themesMap.get(thId)));
                groupsMap.computeIfPresent(gId, (id, groups)->groups.addStudent(sId, studentsMap.get(sId)));

            }
            statement.execute();
            rs.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
                close();
        }
        return groupsMap;
    }

    private static <K, V> V putIfAbsentAndReturn(HashMap<K, V> map, K key, V value) {
        if (key == null) {
            return null;
        }
        map.putIfAbsent(key, value);
        return map.get(key);
    }

}

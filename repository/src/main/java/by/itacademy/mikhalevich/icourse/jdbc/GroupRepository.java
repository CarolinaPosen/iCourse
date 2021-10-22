package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class GroupRepository extends AbstractConnection {
    //language=SQL
    private static final String SELECT_FROM_GROUP_ALL_FIELDS =
            "select * " +
                    " from group g" +
                    " join student_theme_group stg" +
                    " on g.id = stg.group_id" +
                    " join student s " +
                    " on stg.student_id = s.id" +
                    " join theme th " +
                    " on stg.theme_id = th.id" +
                    " join teacher t " +
                    " on g.teacher_id = t.id";

    public HashMap<Integer, Student> allStudents() {
        HashMap<Integer, Student> students = new HashMap<>();

        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement(SELECT_FROM_GROUP_ALL_FIELDS);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {


            }
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return students;
    }
}

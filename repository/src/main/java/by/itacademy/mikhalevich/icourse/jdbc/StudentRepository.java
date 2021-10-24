package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class StudentRepository extends AbstractConnection {

    //language=PostgreSQL
    private static final String SELECT_FROM_STUDENT_ALL_FIELDS =
            "select s.id id, s.name title, s.login log, s.password pass, s.role_id role_id," +
                    " stg.student_mark mark, stg.theme_id theme_id "+
                    " from student s " +
                    " join student_theme_group stg" +
                    " on s.id = stg.student_id";

    public HashMap<Integer, Student> allStudents(){
        HashMap<Integer, Student> students = new HashMap<>();

        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement(SELECT_FROM_STUDENT_ALL_FIELDS);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int sId = rs.getInt("id");
                students.putIfAbsent(sId, new Student()
                        .withId(sId)
                        .withName(rs.getString("title"))
                        .withLogin(rs.getString("log"))
                        .withPassword(rs.getString("pass"))
                        .withRole(rs.getInt("role_id")));

                students.get(sId).addMark(rs.getInt("theme_id"), rs.getInt("mark"));

            }
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
                close();
        }
        return students;
    }
}

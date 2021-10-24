package by.itacademy.mikhalevich.icourse.jdbc;

import by.itacademy.mikhalevich.icourse.model.Trainer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class TrainerRepository extends AbstractConnection {

    //language=PostgreSQL
    private static final String SELECT_FROM_TRAINERS_ALL_FIELDS =
            "select t.id id, t.name title, t.login log, t.password pass, t.role_id role_id," +
                    " s.id salary_id, s.salary salary, s.date salary_date " +
                    " from teacher t " +
                    " join salary s " +
                    " on s.id = s.teacher_id ";

    private static final String SELECT_FROM_TRAINERS_BY_ID =
            "select t.id id, t.name title, t.login log, t.password pass, t.role_id role_id," +
                    " s.id salary_id, s.salary salary, s.date salary_date " +
                    " from teacher t " +
                    " join salary s " +
                    " on s.id = s.teacher_id " +
                    " where t.id = 1";

    public HashMap<Integer, Trainer> allTrainers() {
        HashMap<Integer, Trainer> trainersMap = new HashMap<>();

        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement(SELECT_FROM_TRAINERS_ALL_FIELDS);
            ResultSet rs = statement.executeQuery();

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
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
        return trainersMap;
    }

    public Trainer getTrainerById(Integer id) {
        Trainer trainer = new Trainer();

        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement(SELECT_FROM_TRAINERS_BY_ID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int tId = rs.getInt("id");
                trainer = new Trainer()
                        .withId(tId)
                        .withName(rs.getString("title"))
                        .withLogin(rs.getString("log"))
                        .withPassword(rs.getString("pass"))
                        .withRole(rs.getInt("role_id"))
                        .addSalary(rs.getInt("salary_id"), rs.getInt("salary"));

            }
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
        return trainer;
    }

}

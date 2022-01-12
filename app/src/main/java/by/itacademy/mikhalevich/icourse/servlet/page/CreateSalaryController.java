package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractStudentController;
import by.itacademy.mikhalevich.icourse.servlet.AbstractTeacherController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;
import org.hibernate.tool.schema.extract.spi.TableInformation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Map;

@WebServlet("/create-salary")
public class CreateSalaryController extends AbstractTeacherController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Trainer trainer = new Trainer();

        getSalaryService().createSalary(
                new Salary()
                        .withSalary(new BigDecimal(req.getParameter("salary")))
                        .withDate(Timestamp.from(Instant.now()))
                        .withTrainer(new Trainer().withId(Integer.parseInt(req.getParameter("trainer")))));

        Trainer updateTrainer = getTeacherService().getTrainerById(Integer.parseInt(req.getParameter("trainer"))).get();

        req.setAttribute("teacher", updateTrainer);
        RoutingUtils.forwardToPage("average.jsp", req, resp);
    }

}

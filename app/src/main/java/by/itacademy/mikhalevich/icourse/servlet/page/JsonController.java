package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractController;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet("/json")
public class JsonController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional salary = getSalaryService().getSalaryById(1);
        writeEntityToBody(salary, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String body = req.getReader().lines().collect(Collectors.joining());
        ObjectMapper mapper = new ObjectMapper();
        Salary salary = mapper.readValue(body, Salary.class);

/*        Salary salary = toEntity(Salary.class, req);*/
        getSalaryService().createSalary(salary);

        writeEntityToBody(salary, resp);

/*        Trainer trainer = toEntity(Trainer.class, req);
        writeEntityToBody(getTeacherService().createTrainer(trainer), resp);*/

/*        getSalaryService().createSalary(
                new Salary()
                        .withSalary(BigDecimal.valueOf(777))
                        .withDate(Timestamp.valueOf("1643035600000"))
                        .withTrainerId(2));*/
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}

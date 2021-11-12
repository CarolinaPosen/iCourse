package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;
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

@WebServlet("/salary-edit")
public class SalaryEditController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer trainerId = Integer.parseInt(req.getParameter("trainer"));

        Salary salary = getSalaryService().getSalaryById(id);

        Trainer trainer = getTeacherService().getTrainerById(trainerId);

        getSalaryService().updateSalary(new Salary()
                .withId(id)
                .withSalary(new BigDecimal(req.getParameter("salary")))
                .withDate(salary.getDate())
                .withTrainer(trainer));

        Trainer updateTrainer = getTeacherService().getTrainerById(trainerId);

        req.setAttribute("teacher", updateTrainer);
        RoutingUtils.forwardToPage("average.jsp", req, resp);
    }

}
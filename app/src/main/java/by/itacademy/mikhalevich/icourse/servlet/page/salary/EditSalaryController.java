package by.itacademy.mikhalevich.icourse.servlet.page.salary;

import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractSalaryController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/salary-edit")
public class EditSalaryController extends AbstractSalaryController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer trainerId = Integer.parseInt(req.getParameter("trainer"));

        Salary salary = getSalaryService().getSalaryById(id);

        salary.withSalary(new BigDecimal(req.getParameter("salary")));

        getSalaryService().updateSalary(salary
                                .withSalary(new BigDecimal(req.getParameter("salary"))));

        Trainer updateTrainer = getTeacherService().getTrainerById(trainerId).get();

        req.setAttribute("teacher", updateTrainer);
        RoutingUtils.forwardToPage("average.jsp", req, resp);
    }

}
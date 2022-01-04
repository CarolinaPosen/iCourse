package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.JsonController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/salary")
public class SalaryController extends JsonController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigDecimal averageSalary;

        Trainer trainer = getTeacherService().getTrainerById(Integer.parseInt(req.getParameter("id")));

        if(req.getParameter("month") != null){
            Integer countOfMonth = Integer.parseInt(req.getParameter("month"));
            averageSalary = getTeacherService().averageSalary(trainer.getId(), countOfMonth);
            req.setAttribute("average", averageSalary);
        } else {
            averageSalary = getTeacherService().averageSalary(trainer.getId(), trainer.getSalaries().size());
            req.setAttribute("average", averageSalary);
        }

        req.setAttribute("teacher", trainer);
        RoutingUtils.forwardToPage("average.jsp", req, resp);
    }
}

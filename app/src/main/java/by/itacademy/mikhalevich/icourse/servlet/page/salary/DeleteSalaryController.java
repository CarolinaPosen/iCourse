package by.itacademy.mikhalevich.icourse.servlet.page.salary;

import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractSalaryController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/delete-salary")
public class DeleteSalaryController extends AbstractSalaryController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer trainerId = Integer.parseInt(req.getParameter("teacher"));

        getSalaryService().deleteSalary(Integer.parseInt(req.getParameter("id")));

        Trainer trainer = getTeacherService().getById(trainerId).get();

        req.setAttribute("teacher", trainer);
        RoutingUtils.forwardToPage("average.jsp", req, resp);
    }
}

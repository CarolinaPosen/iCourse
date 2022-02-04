package by.itacademy.mikhalevich.icourse.servlet.page.student;

import by.itacademy.mikhalevich.icourse.model.ExRole;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.servlet.AbstractStudentController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/student-edit")
public class EditStudentController extends AbstractStudentController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student = getStudentService().getById(Integer.parseInt(req.getParameter("id"))).get();

        student
                .withName(req.getParameter("name"));
//                .withLogin(req.getParameter("login"))
//                .withPassword(req.getParameter("password"))
//                .withRole(new ExRole().withTitle(req.getParameter("role")));

        getStudentService().update((student));

        Map<Integer, Student> students = getStudentService().read();
        req.setAttribute("students", students);
        RoutingUtils.forwardToPage("students.jsp", req, resp);
    }
}

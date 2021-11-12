package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/student-edit")
public class StudentEditController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student = getStudentService().getStudentById(Integer.parseInt(req.getParameter("id")));

        student
                .withName(req.getParameter("name"))
                .withLogin(req.getParameter("login"))
                .withPassword(req.getParameter("password"))
                .withRole(new Role().withId(Integer.parseInt(req.getParameter("role"))));

        getStudentService().updateStudent((student));

        Map<Integer, Student> students = getStudentService().readStudents();
        req.setAttribute("students", students);
        RoutingUtils.forwardToPage("students.jsp", req, resp);
    }
}

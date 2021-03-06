package by.itacademy.mikhalevich.icours.servlet.page;

import by.itacademy.mikhalevich.icours.model.Student;
import by.itacademy.mikhalevich.icours.servlet.AbstractController;
import by.itacademy.mikhalevich.icours.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class AllStudentsController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = getStudentService().listAllStudents();
        req.setAttribute("students", students);
        RoutingUtils.forwardToPage("teachers.jsp", req, resp);
    }
}

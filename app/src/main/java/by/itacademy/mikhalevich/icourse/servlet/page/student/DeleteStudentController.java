package by.itacademy.mikhalevich.icourse.servlet.page.student;

import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.servlet.AbstractStudentController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/delete-student")
public class DeleteStudentController extends AbstractStudentController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getStudentService().deleteStudent(Integer.parseInt(req.getParameter("id")));

        Map<Integer, Student> students = getStudentService().readStudents();
        req.setAttribute("students", students);
        RoutingUtils.forwardToPage("students.jsp", req, resp);
    }
}

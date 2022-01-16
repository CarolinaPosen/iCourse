package by.itacademy.mikhalevich.icourse.servlet.page.student;

import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Role;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.servlet.AbstractStudentController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/create-student")
public class CreateStudentController extends AbstractStudentController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Group group = new Group().withId(Integer.parseInt(req.getParameter("group")));

//        Student student = getStudentService().createStudent(
//                new Student()
//                        .withName(req.getParameter("name"))
//                        .withLogin(req.getParameter("login"))
//                        .withPassword(req.getParameter("password"))
//                        .withRole(new Role().withTitle(req.getParameter("role")))).get();

        Student student =
                new Student()
                        .withName(req.getParameter("name"))
                        .withLogin(req.getParameter("login"))
                        .withPassword(req.getParameter("password"))
                        .withRole(new Role().withTitle(req.getParameter("role")));

        student.addGroup(group);

        getStudentService().createStudent(student);

        Map<Integer, Student> students = getStudentService().readStudents();
        req.setAttribute("students", students);
        RoutingUtils.forwardToPage("students.jsp", req, resp);
    }

}

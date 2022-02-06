package by.itacademy.mikhalevich.icourse.servlet.page.student;

import by.itacademy.mikhalevich.icourse.model.ExRole;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.model.auth.Authority;
import by.itacademy.mikhalevich.icourse.model.auth.Credential;
import by.itacademy.mikhalevich.icourse.model.auth.Role;
import by.itacademy.mikhalevich.icourse.servlet.AbstractStudentController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

        Credential credential = new Credential();

        credential.setUsername(req.getParameter("login"));
        credential.setPassword(new BCryptPasswordEncoder().encode(req.getParameter("password")));

        if(req.getParameter("new-student-role-id")!=null) {
            credential.withRole(new Role().withId(Integer.parseInt(req.getParameter("new-student-role-id"))));
        }
        if(req.getParameter("new-student-authorities-id")!=null) {
            credential.withAuthority(new Authority().withId(Integer.parseInt(req.getParameter("new-student-authorities-id"))));
        }

       Student student = new Student()
                .withName(req.getParameter("name"))
                .withCredential(credential);

        student.addGroup(group);

        getStudentService().create(student);

        Map<Integer, Student> students = getStudentService().read();
        req.setAttribute("students", students);
        RoutingUtils.forwardToPage("students.jsp", req, resp);
    }

}

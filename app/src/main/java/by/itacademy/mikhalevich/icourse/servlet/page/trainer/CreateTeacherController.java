package by.itacademy.mikhalevich.icourse.servlet.page.trainer;

import by.itacademy.mikhalevich.icourse.model.ExRole;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.model.auth.Authority;
import by.itacademy.mikhalevich.icourse.model.auth.Credential;
import by.itacademy.mikhalevich.icourse.model.auth.Role;
import by.itacademy.mikhalevich.icourse.servlet.AbstractTeacherController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/create-teacher")
public class CreateTeacherController extends AbstractTeacherController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Credential credential = new Credential();

        credential.setUsername(req.getParameter("login"));
        credential.setPassword(new BCryptPasswordEncoder().encode(req.getParameter("password")));

        if(req.getParameter("new-teacher-role-id")!=null) {
            credential.withRole(new Role().withId(Integer.parseInt(req.getParameter("new-teacher-role-id"))));
        }
        if(req.getParameter("new-teacher-authorities-id")!=null) {
            credential.withAuthority(new Authority().withId(Integer.parseInt(req.getParameter("new-teacher-authorities-id"))));
        }

        getTeacherService().create(new Trainer()
                .withName(req.getParameter("name"))
                .withCredential(credential));

        Map<Integer, Trainer> teachers = getTeacherService().read();
        req.setAttribute("teachers", teachers);
        RoutingUtils.forwardToPage("teachers.jsp", req, resp);
    }

}

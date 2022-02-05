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

@WebServlet("/teacher-edit")
public class EditTeacherController extends AbstractTeacherController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Trainer trainer = getTeacherService().getById(Integer.parseInt(req.getParameter("id"))).get();

        Credential credential = trainer.getCredential();

        credential.setUsername(req.getParameter("login"));
        credential.setPassword(new BCryptPasswordEncoder().encode(req.getParameter("password")));
        credential.withRole(new Role().withId(Integer.parseInt(req.getParameter("role-id"))));
        credential.withAuthority(new Authority().withId(Integer.parseInt(req.getParameter("authorities-id"))));

        trainer
                .withName(req.getParameter("name"))
                .withCredential(credential);

        getTeacherService().update((trainer));

        Map<Integer, Trainer> teachers = getTeacherService().read();
        req.setAttribute("teachers", teachers);
        RoutingUtils.forwardToPage("teachers.jsp", req, resp);
    }
}

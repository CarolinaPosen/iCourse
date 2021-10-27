package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebServlet("/teacher-edit")
public class EditTeacherController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional trainer = getTeacherService().getTrainerById(Integer.parseInt(req.getParameter("id")));

        if (trainer.isPresent()) {
            Trainer updateTrainer = (Trainer) trainer.get();
            updateTrainer
                    .withName(req.getParameter("name"))
                    .withLogin(req.getParameter("login"))
                    .withPassword(req.getParameter("password"))
                    .withRole(Integer.parseInt(req.getParameter("role")));

            getTeacherService().updateTrainer((updateTrainer));
        }

        Map<Integer, Trainer> teachers = getTeacherService().readTeachers();
        req.setAttribute("teachers", teachers);
        RoutingUtils.forwardToPage("teachers.jsp", req, resp);
    }
}

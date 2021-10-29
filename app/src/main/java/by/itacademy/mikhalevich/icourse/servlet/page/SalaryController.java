package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.model.Teacher;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@WebServlet("/salary")
public class SalaryController extends AbstractController {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional trainer = getTeacherService().getTrainerById(1);

        //Может содержаться один на всё приложение fully thread-safe (put into service)
        ObjectMapper mapper = new ObjectMapper();
        Trainer updateTrainer = (Trainer) trainer.get();

        String json = mapper.writeValueAsString(updateTrainer);

        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        writer.print(json);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        BigDecimal averageSalary;

        averageSalary = getTeacherService().averageSalary(id);
        req.setAttribute("average", averageSalary);

        Optional trainer = getTeacherService().getTrainerById(Integer.parseInt(req.getParameter("id")));




/*        if (req.getParameter("month1") != null && trainer.isPresent()) {

                Trainer updateTrainer = (Trainer) trainer.get();
                updateTrainer
                        .addSalary());

                getTeacherService().updateTrainer((updateTrainer));



                    Integer.parseInt(req.getParameter("age")),
                    List.of(
                            Integer.parseInt(req.getParameter("month1")),
                            Integer.parseInt(req.getParameter("month2")),
                            Integer.parseInt(req.getParameter("month3")),
                            Integer.parseInt(req.getParameter("month4")),
                            Integer.parseInt(req.getParameter("month5")),
                            Integer.parseInt(req.getParameter("month6")),
                            Integer.parseInt(req.getParameter("month7")),
                            Integer.parseInt(req.getParameter("month8")),
                            Integer.parseInt(req.getParameter("month9")),
                            Integer.parseInt(req.getParameter("month10")),
                            Integer.parseInt(req.getParameter("month11")),
                            Integer.parseInt(req.getParameter("month12"))
                    )));

            averageSalary = getTeacherService().averageSalary
                    (id, Integer.parseInt(req.getParameter("count")));
            req.setAttribute("average", averageSalary);

        }*/

        Optional teacher = getTeacherService().getTrainerById(id);

        req.setAttribute("teacher", teacher.get());
        RoutingUtils.forwardToPage("average.jsp", req, resp);
    }
}

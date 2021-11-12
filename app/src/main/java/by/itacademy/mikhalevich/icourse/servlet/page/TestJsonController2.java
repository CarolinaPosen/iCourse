package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.dto.Trainers;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.JsonController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet("/json2")
public class TestJsonController2 extends JsonController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

/*        Optional salary = getSalaryService().getSalaryById(1);
        writeEntityToBody(salary, resp);*/

        Map trainer = getTeacherService().readTeachers();

        System.out.println("MAP: "+trainer);
        //Optional trainer = getTeacherService().getTrainerById(1);

        List<Trainer> list = new ArrayList<Trainer>(trainer.values());

        System.out.println("LIST: "+list);

        Trainers trainers = new Trainers("trainers", list);

        System.out.println("TRAINERS: "+trainers);

        writeEntityToBody(trainers, resp);

/*        Map<Integer, Trainer> teachers = getTeacherService().readTeachers();
        req.setAttribute("teachers", teachers);*/
        //RoutingUtils.forwardToPage("jsontest.jsp", req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


/*        String body = req.getReader().lines().collect(Collectors.joining());
        ObjectMapper mapper = new ObjectMapper();
        Salary salary = mapper.readValue(body, Salary.class);
        getSalaryService().createSalary(salary);*/

        //String body = req.getReader().lines().collect(Collectors.joining());
        //ObjectMapper mapper = new ObjectMapper();
        //Trainer trainer = mapper.readValue(body, Trainer.class);



        Trainer trainer = toEntity(Trainer.class, req);

        getTeacherService().createTrainer(trainer);

        writeEntityToBody(getTeacherService().createTrainer(trainer), resp);
        writeEntityToBody(trainer, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

}


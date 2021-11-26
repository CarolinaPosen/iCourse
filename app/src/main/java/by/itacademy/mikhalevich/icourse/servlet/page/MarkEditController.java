package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.model.Mark;
import by.itacademy.mikhalevich.icourse.model.Salary;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servlet.AbstractController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

@WebServlet("/mark-edit")
public class MarkEditController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer studentId = Integer.parseInt(req.getParameter("student"));

//        Mark mark = getStudentService().getMarkById(id);

//        Student student = getStudentService().getStudentById(studentId);
//
//
//                student.addMark(new Mark()
//                .withId(id)
//                .withMark(Integer.parseInt(req.getParameter("mark")))
//                .withDate(new Tireq.getParameter("date"));



        Student updateStudent = getStudentService().getStudentById(studentId);

        req.setAttribute("student", updateStudent);
        RoutingUtils.forwardToPage("marks.jsp", req, resp);
    }

}

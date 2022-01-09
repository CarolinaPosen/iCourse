package by.itacademy.mikhalevich.icourse.servlet.test;

import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "StudentServlet",
        urlPatterns = "/student-record")
public class StudentServlet extends HttpServlet {

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("studentRecord", new Student(1, "John", "Doe"));

        RoutingUtils.forwardToPage("student-record.jsp", request, response);
    }

    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        System.out.println();
        processRequest(request, response);
    }
}
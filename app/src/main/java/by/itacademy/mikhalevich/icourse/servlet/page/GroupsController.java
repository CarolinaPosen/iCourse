package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.servlet.AbstractController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groups")
public class GroupsController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoutingUtils.forwardToPage("groups.jsp", req, resp);
    }
}
package by.itacademy.mikhalevich.icourse.servlet.page.group;

import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.servlet.AbstractGroupController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/group-students-edit")
public class EditGroupStudentController extends AbstractGroupController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Group group = getGroupService().getGroupById(Integer.parseInt(req.getParameter("group-id"))).get();

        req.setAttribute("group", group);
        RoutingUtils.forwardToPage("group-students.jsp", req, resp);
    }


}

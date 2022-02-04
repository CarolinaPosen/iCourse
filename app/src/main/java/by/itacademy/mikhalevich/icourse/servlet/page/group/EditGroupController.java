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

@WebServlet("/group-edit")
public class EditGroupController extends AbstractGroupController {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Group group = getGroupService().getById(Integer.parseInt(req.getParameter("id"))).get();
        group.withTitle(req.getParameter("name"));
        getGroupService().update(group);

        Map<Integer, Group> groups = getGroupService().read();
        req.setAttribute("groups", groups);
        RoutingUtils.forwardToPage("groups.jsp", req, resp);
    }


}

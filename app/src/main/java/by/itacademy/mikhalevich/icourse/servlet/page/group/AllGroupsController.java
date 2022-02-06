package by.itacademy.mikhalevich.icourse.servlet.page.group;

import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.servlet.AbstractGroupController;
import by.itacademy.mikhalevich.icourse.util.RoutingUtils;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/groups")
public class AllGroupsController extends AbstractGroupController {

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'READ_INFO')")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<Integer, Group> groups = getGroupService().read();
        req.setAttribute("groups", groups);
        RoutingUtils.forwardToPage("groups.jsp", req, resp);
    }
}
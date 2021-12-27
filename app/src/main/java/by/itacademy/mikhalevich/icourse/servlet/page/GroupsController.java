package by.itacademy.mikhalevich.icourse.servlet.page;

import by.itacademy.mikhalevich.icourse.impl.GroupServiceImpl;
import by.itacademy.mikhalevich.icourse.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

//@WebServlet("/groups")
@Controller
public class GroupsController {

    private final GroupServiceImpl groupService;

    @Autowired()
    public GroupsController(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    //    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Map<Integer, Group> groups = getGroupService().readGroups();
//
//        req.setAttribute("groups", groups);
//        RoutingUtils.forwardToPage("groups.jsp", req, resp);
//    }

    @RequestMapping(path = "groups", method = RequestMethod.GET)
    protected ModelAndView allGroups()  {
        ModelAndView modelAndView = new ModelAndView();

        Map<Integer, Group> groups = Map.of(1, new Group().withId(1).withTitle("Group1"));

        modelAndView.addObject("groups", groupService.readGroups());
        modelAndView.addObject("currentPage", "page/groups.jsp");
        modelAndView.setViewName("page-template");
        return modelAndView;
    }
}
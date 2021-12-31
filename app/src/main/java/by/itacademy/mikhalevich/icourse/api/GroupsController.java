package by.itacademy.mikhalevich.icourse.api;

import by.itacademy.mikhalevich.icourse.impl.GroupServiceImpl;
import by.itacademy.mikhalevich.icourse.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
public class GroupsController {

    private final GroupServiceImpl groupService;

    @Autowired()
    public GroupsController(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(path = "/api/groups", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody // Ответ кладем в ResponseBody
    public Map<Integer, Group> allGroups()  {
        return groupService.readGroups();
    }

    @RequestMapping(path = "/api/groups/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody // Ответ кладем в ResponseBody
    public Group getGroup(@PathVariable int id)  {
        return groupService.getGroupById(id);
    }

    @RequestMapping(path = "/api/groups", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Group createGroup(@RequestBody Group group)  {
        return groupService.createGroup(group);
    }

    @RequestMapping(path = "/api/groups", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Group updateGroup(@RequestBody Group group)  {
        return group;
    }

    @RequestMapping(path = "/api/groups/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Group deleteGroup(@PathVariable int id)  {

        Group deletedGroup = groupService.getGroupById(id);
        return groupService.deleteGroup(deletedGroup).get();

    }
}
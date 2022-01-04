package by.itacademy.mikhalevich.icourse.api;

import by.itacademy.mikhalevich.icourse.impl.GroupServiceImpl;
import by.itacademy.mikhalevich.icourse.model.Group;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping(path = "/api/groups", produces = "application/json")
public class GroupsController {

    private final GroupServiceImpl groupService;

    @Autowired()
    public GroupsController(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public Map<Integer, Group> allGroups()  {
        return groupService.readGroups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable int id)  {
        return ResponseEntity.ok(groupService.getGroupById(id));
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group)  {
        return groupService.createGroup(group);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable int id, @RequestBody Group group)  {
        if(group != null && id != group.getId()){
            return ResponseEntity.badRequest()
                    .body("Group id must be equal with id in path: "+ id +" != "+ group.getId());
        }
        return ResponseEntity.ok(groupService.createGroup(group));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Group> deleteGroup(@PathVariable Integer id)  {
        Group group = groupService.getGroupById(id);
        return ResponseEntity.of(groupService.deleteGroup(group));
    }
}
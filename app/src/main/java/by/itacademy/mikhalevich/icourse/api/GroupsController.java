package by.itacademy.mikhalevich.icourse.api;

import by.itacademy.mikhalevich.icourse.GroupService;
import by.itacademy.mikhalevich.icourse.model.Group;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/api/groups", produces = "application/json")
@PropertySource("classpath:application.properties")
public class GroupsController {

    private GroupService groupService;

    private Map<String, GroupService> serviceMap;
    @Value("${group-service.type}")
    private String serviceType;

    @PostConstruct
    private void init(){
        groupService = serviceMap.get(serviceType);
        log.info("Group controller autowired service: {}", groupService.toString());
    }

    @Autowired
    public void setServiceMap(Map<String, GroupService> serviceMap){
        this.serviceMap = serviceMap;
    }

//    @Autowired
//    public GroupsController(@Qualifier("groupServiceSpringImpl") GroupService groupService) {
//        this.groupService = groupService;
//    }

    @GetMapping
    public Map<Integer, Group> allGroups() {
        return groupService.readGroups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable int id) {
        Optional<Group> getGroup = groupService.getGroupById(id);
        if (getGroup.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
        } else {
            return ResponseEntity.of(groupService.getGroupById(id));
        }
    }

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        Optional<Group> createGroup = groupService.createGroup(group);
        if (createGroup.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + group.getId() + " not exists");
        } else {
            return ResponseEntity.of(createGroup);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable int id, @RequestBody Group group) {
        if (group != null && id != group.getId()) {
            return ResponseEntity.badRequest()
                    .body("Group id must be equal with id in path: " + id + " != " + group.getId());
        }
        Optional<Group> updatedGroup = groupService.updateGroup(group);
        if (updatedGroup.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + group.getId() + " not exists");
        } else {
            return ResponseEntity.of(updatedGroup);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Group> deleteGroup(@PathVariable Integer id) {
        Optional<Group> group = groupService.getGroupById(id);
        if (group.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
        } else {
            Optional<Group> deletedGroup = groupService.deleteGroup(group.get());
            if (deletedGroup.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + group.get().getId() + " not exists");
            } else {
                return ResponseEntity.of(deletedGroup);
            }
        }
    }
}
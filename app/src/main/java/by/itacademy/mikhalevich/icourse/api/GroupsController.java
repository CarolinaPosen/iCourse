package by.itacademy.mikhalevich.icourse.api;

import by.itacademy.mikhalevich.icourse.GroupService;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.servicespring.base.GroupBaseService;
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

    private GroupBaseService groupService;

    private Map<String, GroupBaseService> serviceMap;
    @Value("${group-service.type}")
    private String serviceType;

    @PostConstruct
    private void init(){
        groupService = serviceMap.get(serviceType);
        log.info("Group REST controller autowired service: {}", groupService.getClass().getSimpleName());
    }

    @Autowired
    public void setServiceMap(Map<String, GroupBaseService> serviceMap){
        this.serviceMap = serviceMap;
    }

//    @Autowired
//    public GroupsController(@Qualifier("groupServiceSpringImpl") GroupService groupService) {
//        this.groupService = groupService;
//    }

    @GetMapping
    public Map<Integer, Group> allGroups() {
        return groupService.read();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable int id) {
        Optional<Group> getGroup = groupService.getById(id);
        if (!getGroup.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
        } else {
            return ResponseEntity.of(getGroup);
        }
    }

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        Optional<Group> createGroup = groupService.create(group);
        if (!createGroup.isPresent()) {
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
        Optional<Group> updatedGroup = groupService.update(group);
        if (!updatedGroup.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + group.getId() + " not exists");
        } else {
            return ResponseEntity.of(updatedGroup);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Group> deleteGroup(@PathVariable Integer id) {
//        Optional<Group> group = groupService.getGroupById(id);
//        if (group.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
//        } else {
            Optional<Group> deletedGroup = groupService.delete(id);
            if (!deletedGroup.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
            } else {
                return ResponseEntity.of(deletedGroup);
            }
//        }
    }
}
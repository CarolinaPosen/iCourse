package by.itacademy.mikhalevich.icourse.api;

import by.itacademy.mikhalevich.icourse.Service;
import by.itacademy.mikhalevich.icourse.exception.ControllerErrorException;
import by.itacademy.mikhalevich.icourse.exception.ControllerException;
import by.itacademy.mikhalevich.icourse.model.Group;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping
@PropertySource("classpath:application.properties")
public class GroupsController {

    private Service<Group> groupService;

    private Map<String, Service<Group>> serviceMap;
    @Value("${group-service.type}")
    private String serviceType;

    @PostConstruct
    private void init(){
        groupService = serviceMap.get(serviceType);
        log.info("Group REST controller autowired service: {}", groupService.getClass().getSimpleName());
    }

    @Autowired
    public void setServiceMap(Map<String, Service<Group>> serviceMap){
        this.serviceMap = serviceMap;
    }


    @GetMapping(path = "/api/groups", produces = "application/json")
    public Map<Integer, Group> allGroups() {
        return groupService.read();
    }

    @GetMapping(path = "/api/groups/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable int id) {
        Optional<Group> getGroup = groupService.getById(id);
        if (!getGroup.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
        } else {
            return ResponseEntity.of(getGroup);
        }
    }

    @PostMapping(path = "/api/groups", produces = "application/json")
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        Optional<Group> createGroup = groupService.create(group);
        if (!createGroup.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + group.getId() + " not exists");
        } else {
            return ResponseEntity.of(createGroup);
        }
    }

    @PutMapping(path = "/api/groups/{id}", produces = "application/json")
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

    @DeleteMapping(path = "/api/groups/{id}", produces = "application/json")
    public ResponseEntity<Group> deleteGroup(@PathVariable Integer id) {
            Optional<Group> deletedGroup = groupService.delete(id);
            if (!deletedGroup.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
            } else {
                return new ResponseEntity(HttpStatus.OK);
            }
    }

    @PatchMapping(path = "/api/groups/teacher/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<Group> updateGroupTeacher(@PathVariable Integer id, @RequestBody JsonPatch patch) {
        try {
            Optional<Group> group = groupService.getById(id);
            Group groupPatched = applyPatchToCustomer(patch, group.get());
            groupService.update(groupPatched);
            return ResponseEntity.ok(groupPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (ControllerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    private Group applyPatchToCustomer(JsonPatch patch, Group targetGroup) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetGroup, JsonNode.class));
        return objectMapper.treeToValue(patched, Group.class);
    }

}
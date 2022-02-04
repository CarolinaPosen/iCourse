package by.itacademy.mikhalevich.icourse.api;

import by.itacademy.mikhalevich.icourse.GroupService;
import by.itacademy.mikhalevich.icourse.Service;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping(path = "/api/base", produces = "application/json")
public class ExperimentGroupController {

    private Service<Trainer> service;

    @Autowired
    public ExperimentGroupController(@Qualifier("trainerServiceMemoryImpl") Service service) {
        this.service = service;
    }

    @GetMapping
    public Map<Integer, Trainer> allGroups() {
        return service.read();
}

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getGroup(@PathVariable int id) {
        Optional<Trainer> getGroup = service.getById(id);
        if (!getGroup.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
        } else {
            return ResponseEntity.of(getGroup);
        }
    }

    @PostMapping
    public ResponseEntity<Trainer> createGroup(@RequestBody Trainer trainer) {
        Optional<Trainer> createGroup = service.create(trainer);
        if (!createGroup.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + trainer.getId() + " not exists");
        } else {
            return ResponseEntity.of(createGroup);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable int id, @RequestBody Trainer group) {
        if (group != null && id != group.getId()) {
            return ResponseEntity.badRequest()
                    .body("Group id must be equal with id in path: " + id + " != " + group.getId());
        }
        Optional<Trainer> updatedGroup = service.update(group);
        if (!updatedGroup.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + group.getId() + " not exists");
        } else {
            return ResponseEntity.of(updatedGroup);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Trainer> deleteGroup(@PathVariable Integer id) {
            Optional<Trainer> deletedGroup = service.delete(id);
            if (!deletedGroup.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Experiment Entity id: " + id + " not exists");
            } else {
                return ResponseEntity.of(deletedGroup);
            }
    }
}
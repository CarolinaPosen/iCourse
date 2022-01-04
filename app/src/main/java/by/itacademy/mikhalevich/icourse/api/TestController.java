package by.itacademy.mikhalevich.icourse.api;

import by.itacademy.mikhalevich.icourse.dto.Trainers;
import by.itacademy.mikhalevich.icourse.impl.GroupServiceImpl;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Student;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/test", produces = "application/json")
public class TestController {

//    private final GroupServiceImpl groupService;

//    @Autowired()
//    public TestController(GroupServiceImpl groupService) {
//        this.groupService = groupService;
//    }

    Trainers student = new Trainers("Kifi");

    @GetMapping
    public ResponseEntity<Trainers> allGroups()  {
        return ResponseEntity.of(Optional.ofNullable(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGroup(@PathVariable int id)  {
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Trainers> createDepartment(@RequestBody Trainers student) {
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable int id, @RequestBody Trainers student)  {
        if(student != null){
            return ResponseEntity.badRequest()
                    .body("Student id must be equal with id in path: "+ id);
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Trainers> deleteGroup(@PathVariable Integer id)  {
        return ResponseEntity.ok(student);
    }
}
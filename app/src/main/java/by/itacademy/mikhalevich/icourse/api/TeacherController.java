package by.itacademy.mikhalevich.icourse.api;

import by.itacademy.mikhalevich.icourse.service.TrainerServiceImpl;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/trainers", produces = "application/json")
public class TeacherController {

    private final TrainerServiceImpl trainerService;

    @Autowired()
    public TeacherController(TrainerServiceImpl trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public Map<Integer, Trainer> allTrainers()  {
        return trainerService.readTeachers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainer(@PathVariable int id)  {
        return ResponseEntity.ok(trainerService.getTrainerById(id));
    }

    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer)  {
        return ResponseEntity.of(trainerService.createTrainer(trainer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTrainer(@PathVariable int id, @RequestBody Trainer trainer)  {
        if(trainer != null && id != trainer.getId()){
            return ResponseEntity.badRequest()
                    .body("Trainer id must be equal with id in path: "+ id +" != "+ trainer.getId());
        } else {
            return ResponseEntity.of(trainerService.createTrainer(trainer));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Trainer> deleteTrainer(@PathVariable Integer id)  {
        Trainer trainer = trainerService.getTrainerById(id);
        return ResponseEntity.ok(trainerService.deleteTrainer(trainer.getId()).get());
    }
}
package by.itacademy.mikhalevich.icourse.api;

import by.itacademy.mikhalevich.icourse.StudentService;
import by.itacademy.mikhalevich.icourse.TeacherService;
import by.itacademy.mikhalevich.icourse.service.TrainerServiceImpl;
import by.itacademy.mikhalevich.icourse.model.Trainer;
import by.itacademy.mikhalevich.icourse.servicespring.TrainerServiceSpringImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(path = "/api/trainers", produces = "application/json")
@PropertySource("classpath:application.properties")
public class TeacherController {

    private TeacherService trainerService;

    private Map<String, TeacherService> serviceMap;
    @Value("${trainer-service.type}")
    private String serviceType;

    @PostConstruct
    private void init(){
        trainerService = serviceMap.get(serviceType);
        log.info("Trainer controller autowired service: {}", trainerService.toString());
    }

    @Autowired
    public void setServiceMap(Map<String, TeacherService> serviceMap){
        this.serviceMap = serviceMap;
    }

//    @Autowired()
//    public TeacherController(@Qualifier("trainerServiceSpringImpl") TeacherService trainerService) {
//        this.trainerService = trainerService;
//    }

    @GetMapping
    public Map<Integer, Trainer> allTrainers()  {
        return trainerService.readTeachers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainer(@PathVariable int id)  {
        return ResponseEntity.of(trainerService.getTrainerById(id));
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
        Trainer trainer = trainerService.getTrainerById(id).get();
        return ResponseEntity.ok(trainerService.deleteTrainer(trainer.getId()).get());
    }
}
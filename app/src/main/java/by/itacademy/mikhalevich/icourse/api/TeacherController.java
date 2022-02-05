package by.itacademy.mikhalevich.icourse.api;

import by.itacademy.mikhalevich.icourse.Service;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.model.Trainer;
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
@RequestMapping(path = "/api/trainers", produces = "application/json")
@PropertySource("classpath:application.properties")
public class TeacherController {

    private Service<Trainer> trainerService;

    private Map<String, Service<Trainer>> serviceMap;
    @Value("${trainer-service.type}")
    private String serviceType;

    @PostConstruct
    private void init(){
        trainerService = serviceMap.get(serviceType);
        log.info("Trainer controller autowired service: {}", trainerService.toString());
    }

    @Autowired
    public void setServiceMap(Map<String, Service<Trainer>> serviceMap){
        this.serviceMap = serviceMap;
    }


    @GetMapping
    public Map<Integer, Trainer> allTrainers()  {
        return trainerService.read();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainer(@PathVariable int id)  {
        return ResponseEntity.of(trainerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer)  {
        return ResponseEntity.of(trainerService.create(trainer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTrainer(@PathVariable int id, @RequestBody Trainer trainer)  {
        if(trainer != null && id != trainer.getId()){
            return ResponseEntity.badRequest()
                    .body("Trainer id must be equal with id in path: "+ id +" != "+ trainer.getId());
        } else {
            return ResponseEntity.of(trainerService.update(trainer));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Trainer> deleteTrainer(@PathVariable Integer id)  {
        Optional<Trainer> deletedTrainer = trainerService.delete(id);
        if (!deletedTrainer.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group id: " + id + " not exists");
        } else {
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}
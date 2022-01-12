package by.itacademy.mikhalevich.icourse.api;

import by.itacademy.mikhalevich.icourse.GroupService;
import by.itacademy.mikhalevich.icourse.StudentService;
import by.itacademy.mikhalevich.icourse.model.Group;
import by.itacademy.mikhalevich.icourse.service.StudentServiceImpl;
import by.itacademy.mikhalevich.icourse.model.Student;
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
@RequestMapping(path = "/api/students", produces = "application/json")
@PropertySource("classpath:application.properties")
public class StudentController {

    private StudentService studentService;

    private Map<String, StudentService> serviceMap;
    @Value("${student-service.type}")
    private String serviceType;

    @PostConstruct
    private void init(){
        studentService = serviceMap.get(serviceType);
        log.info("Student controller autowired service: {}", studentService.toString());
    }

    @Autowired
    public void setServiceMap(Map<String, StudentService> serviceMap){
        this.serviceMap = serviceMap;
    }

//    @Autowired()
//    public StudentController(@Qualifier("studentServiceSpringImpl") StudentService studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping
    public Map<Integer, Student> allStudents()  {
        return studentService.readStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id)  {
        return ResponseEntity.of(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student)  {
        return ResponseEntity.of(studentService.createStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student)  {
        if(student != null && id != student.getId()){
            return ResponseEntity.badRequest()
                    .body("Student id must be equal with id in path: "+ id +" != "+ student.getId());
        } else {
            return ResponseEntity.of(studentService.createStudent(student));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer id)  {


//        Student student = studentService.getStudentById(id);
//        return ResponseEntity.of(studentService.deleteStudent(student.getId()));


        Optional<Student> student = studentService.getStudentById(id);
        if (student.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student id: " + id + " not exists");
        } else {
            Optional<Student> deletedStudent = studentService.deleteStudent(student.get());
            if (deletedStudent.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student id: " + student.get().getId() + " not exists");
            } else {
                return ResponseEntity.of(deletedStudent);
            }
        }
    }

}
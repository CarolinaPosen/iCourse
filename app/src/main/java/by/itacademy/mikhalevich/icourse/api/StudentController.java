package by.itacademy.mikhalevich.icourse.api;

import by.itacademy.mikhalevich.icourse.impl.StudentServiceImpl;
import by.itacademy.mikhalevich.icourse.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/students", produces = "application/json")
public class StudentController {

    private final StudentServiceImpl studentService;

    @Autowired()
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Map<Integer, Student> allStudents()  {
        return studentService.readStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id)  {
        return ResponseEntity.ok(studentService.getStudentById(id));
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
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(studentService.deleteStudent(student.getId()).get());
    }
}
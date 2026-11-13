package SmallProjectServiceLayer;


import org.springframework.web.bind.annotation.*;
import java.util.List;

// @RestController: ye class browser/Postman ki request leti hai aur response deti hai.
// Isme logic nahi likhte, sirf service ko call karte hain.
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    // AUTOWIRING: Spring StudentService ka object yahan inject kar deta hai
    public StudentController(StudentService service) {
        this.service = service;
    }

    // GET http://localhost:8080/students  -> saare students
    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    // POST http://localhost:8080/students -> naya student add
    @PostMapping
    public Student add(@RequestBody Student student) {
        return service.addStudent(student);
    }
}
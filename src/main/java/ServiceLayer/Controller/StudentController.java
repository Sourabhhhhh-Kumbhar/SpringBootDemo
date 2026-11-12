package ServiceLayer.Controller;

import ServiceLayer.Model.Student;
import ServiceLayer.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//CONTROLLER: Receives the http request, calls the service, returns the response
//No logic here, just routing
@RestController
@RequestMapping("/students")
public class StudentController
{
    private final StudentService service;

    //AUTOWIRING: Spring injects StudentService
    public StudentController(StudentService service)
    {
        this.service = service;
    }
    @GetMapping
    public List<Student> getAll()
    {
        return service.getAllStudents();
    }

    @GetMapping("/{id}/grade")
    public String getGrade(@PathVariable int id)
    {
        return service.getGrade(id);
    }

    @PostMapping
    public Student add(@RequestBody Student student)
    {
        return service.addStudent(student);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id)
    {
        service.deleteStudent(id);
        return "Deleted Student " + id;
    }
}

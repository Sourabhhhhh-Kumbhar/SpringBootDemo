package BasicSpringBoot;



import BasicSpringBoot.NotificationService;
import BasicSpringBoot.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @RestController = @Controller + @ResponseBody
 *   -> ye class HTTP requests handle karti hai
 *   -> jo bhi method return kare wo seedha JSON/text response ban ke jaata hai
 *      (HTML page nahi dhundta)
 *
 * @RequestMapping("/students") = is controller ka base URL.
 *   Andar ke saare URLs "/students" se shuru honge.
 */
@RestController
@RequestMapping("/students")
public class StudentController
{

    private final StudentService service;
    private final NotificationService notificationService;

    // Dono beans Spring khud inject karega
    public StudentController(StudentService service,
                             NotificationService notificationService)
    {
        this.service = service;
        this.notificationService = notificationService;
    }

    /*
     * @PostMapping = sirf HTTP POST request ko is method se jodta hai.
     * URL: POST /students/Rahul
     * @PathVariable = URL ke {name} wale hisse ko method parameter me daal deta hai.
     */
    @PostMapping("/{name}")
    public String addStudent(@PathVariable String name)
    {
        service.addStudent(name);
        notificationService.notifyUser("Naya student add hua: " + name);
        return "Added: " + name;
    }

    /*
     * @GetMapping = sirf HTTP GET request ke liye.
     * URL: GET /students
     * List return kiya to Spring use apne aap JSON me convert kar deta hai.
     */
    @GetMapping
    public List<String> getAllStudents()
    {
        return service.getAllStudents();
    }

    /*
     * @RequestParam = query parameter padhta hai.
     * URL: GET /students/search?name=Rahul
     */
    @GetMapping("/search")
    public String search(@RequestParam String name)
    {
        return "Searching for: " + name;
    }
}
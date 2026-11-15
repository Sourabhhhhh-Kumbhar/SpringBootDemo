package BasicSpringBoot;

import BasicSpringBoot.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Service = business logic layer.
 *
 * Rules, validation, calculations sab yahan likhte hain.
 * Controller sirf request leta hai, DB ka kaam repository karti hai,
 * aur beech ka "dimaag" service hoti hai.
 *
 * Ye bhi @Component hi hai, bas layer ka meaning batata hai.
 */
@Service
public class StudentService {

    private final StudentRepository repo;

    // Constructor injection: Spring StudentRepository ka bean dhundh ke
    // yahan khud pass kar deta hai. Ek hi constructor ho to @Autowired optional hai.
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public void addStudent(String name) {
        // business rule: naam khali nahi hona chahiye
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name empty nahi ho sakta");
        }
        repo.save(name);
    }

    public List<String> getAllStudents() {
        return repo.findAll();
    }
}

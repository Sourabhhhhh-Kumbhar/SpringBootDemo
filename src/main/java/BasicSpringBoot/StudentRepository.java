package BasicSpringBoot;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
 * @Repository = data access layer (database se baat karne wali class).
 *
 * Ye bhi ek @Component hi hai, bas naam se pata chalta hai ki ye DB layer hai.
 * Extra fayda: database ke exceptions ko Spring ke DataAccessException me
 * convert kar deta hai (exception translation).
 *
 * Abhi hum DB nahi laga rahe, isliye List use kiya hai database ki jagah.
 */
@Repository
public class StudentRepository
{

    // fake database
    private final List<String> students = new ArrayList<>();

    public void save(String name)
    {
        students.add(name);          // real project me: INSERT query
    }

    public List<String> findAll()
    {
        return students;             // real project me: SELECT * FROM students
    }
}
package ServiceLayer.Repository;

import ServiceLayer.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Repository: Only data access (save, find, delete).
//No business rules here. Later this becomes a JPA interface
@Repository
public class StudentRepository
{
    //Fake database for now
    private final List<Student> students = new ArrayList<>();

    public StudentRepository()
    {
        students.add(new Student(1, "Sourabh", 24));
        students.add(new Student(2, "Anikaaa", 21));
    }

    public List<Student> findAll()
    {
        return students;
    }

    public Optional<Student> findById(int id)
    {
        return students.stream().filter(student -> student.getId() == id).findFirst();
    }

    public Student save(Student student)
    {
        students.add(student);
        return student;
    }

    public void deleteById(int id)
    {
        students.removeIf(student -> student.getId() == id);
    }
}

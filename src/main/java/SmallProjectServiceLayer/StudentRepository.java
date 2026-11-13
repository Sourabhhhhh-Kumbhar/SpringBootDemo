package SmallProjectServiceLayer;

//Data store karne wali layer

//@Repository: Spring ko batata hai "ye class data ka kaam karti hai"
//Spring iska object khud bana dega hume "new" nahi likhna padega
//Is layer mein sirf data save/fetch hota hai koi rule ya logic nahi.

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository
{
    //Abhi database nahi hai isiliye list ko database maan rahe hai
    private final List<Student> students = new ArrayList<>();

    public StudentRepository()
    {
        students.add(new Student(1, "Anikaaaaaaa", 85));
        students.add(new Student(2, "Nishaaaaaa", 91));
    }

    public List<Student> findAll()
    {
        return students;
    }
    public Student save(Student student)
    {
        students.add(student);
        return student;
    }
}

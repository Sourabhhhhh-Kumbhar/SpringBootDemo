package SmallProjectServiceLayer;

//Asli service layer

//@Service: Spring ko batata hai "Ye business logic wali class hai"
//Service layer ka kaam: rules lagana aur decision lena
//Controller seedha repository ko call nahi karata beech mein service hoti hai

import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    private final StudentRepository repository;

    //AUTOWIRING: Spring khud StudentRepository ka object yaha de deta hai
    //Hume "new StudentRepository()" likhne ki zarurat nahi.
    public StudentService(StudentRepository repository)
    {
        this.repository = repository;
    }

    public Student addStudent(Student student)
    {
        //Business rule: Marks 0 to 100 ke beech hi hone chahiye
        //Ye chcek service mein isiliye hai kyonki rule lagana service ka kaam hai
        //repository ka nahi(wo bad save karta hai)
        if(student.getMarks() < 0 || student.getMarks() > 100)
        {
            throw new IllegalArgumentException("Marks 0 se 100 ke beech hone chahiye.");
        }

        //Rule pass hua ab repository ko bolo save karne ko
        return repository.save(student);
    }

    public String getGrade(int marks)
    {
        //Calculation: grade nikalana bhi business logic hai, isiliye service mein.
        if(marks >= 90) return "A";
        if(marks >= 75) return "B";
        if(marks >= 50) return "C";
        return "Fail";
    }
}

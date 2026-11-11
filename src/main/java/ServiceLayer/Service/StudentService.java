package ServiceLayer.Service;


import ServiceLayer.Model.Student;
import ServiceLayer.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//SERVICE: the brain of the app. All business logic lives here.
//Controller calls this. This calls the repository.
@Service
public class StudentService {
    private final StudentRepository repository;

    //AUTOWIRING: Spring injects StudentRepository automatically
    public StudentService(StudentRepository repository)
    {
        this.repository = repository;
    }
    public List<Student> getAllStudents()
    {
        return repository.findAll();
    }
    public Student getStudentById(int id)
    {
        //Business rule: if not found throw our own error
        return repository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
    }

    public Student addStudent(Student student)
    {
        //Rule 1: name must not be empty
        if(student.getName() == null || student.getName().isBlank())
        {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        //Rule 2: Marks must be between 0 and 100
        if(student.getMarks() < 0 || student.getMarks() > 100)
        {
            throw new IllegalArgumentException("Student marks should be between 0 and 100");
        }
        //Rule 3: no duplicate ids
        if(repository.findById(student.getId()).isPresent())
        {
            throw new IllegalArgumentException("Student with id " + student.getId() + " already exists");
        }
        //All checks passed so ask the repository to save
        return repository.save(student);
    }
    public void deleteStudent(int id)
    {
        getStudentById(id);         //Reuses the not-found check
        repository.deleteById(id);
    }

    //Example of calculation: this belongs in the service not the controller
    public String getGrade(int id)
    {
        int marks = getStudentById(id).getMarks();
        if(marks >= 90) return "A";
        if(marks >= 75) return "B";
        if(marks >= 50) return "C";
        return "Fail";
    }

}

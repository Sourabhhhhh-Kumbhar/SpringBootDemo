package ServiceLayer.Exception;

//Our own error type, thrown by the service when a student doesn't exist
public class StudentNotFoundException extends RuntimeException
{
    public StudentNotFoundException(String message)
    {
        super(message);
    }
}

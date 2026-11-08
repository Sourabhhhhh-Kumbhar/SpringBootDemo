package SmallProject;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService
{
    @Override
    public void send(String message)
    {
        System.out.println("Email sent: " + message);
    }
}


//This is the bean That Implements It
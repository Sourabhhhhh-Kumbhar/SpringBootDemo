package SmallProject;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService
{
    @Override
    public void sendMessage(String message)
    {
        System.out.println("Email Sent: " +  message);
    }
}


//This is the bean That Implements It
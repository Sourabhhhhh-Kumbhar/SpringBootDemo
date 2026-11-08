package SmallProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService
{
    private final MessageService messageService;

    @Autowired
    public NotificationService(MessageService messageService)
    {
        this.messageService = messageService;
    }
    public void notifyUser(String text)
    {
        messageService.send(text);
    }
}

//This is where autowiring happens
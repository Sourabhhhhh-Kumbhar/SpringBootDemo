package BasicSpringBoot;

import BasicSpringBoot.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @Autowired = "Spring, jo object mujhe chahiye wo tu khud laa ke de."
 * Isko Dependency Injection (DI) kehte hain.
 * Hum new EmailSender() nahi likhte, Spring container me se bean utha ke deta hai.
 *
 * Injection ke 3 tareeke hain (neeche teeno dikhaye hain, ek time pe ek hi use karo):
 */
@Service
public class NotificationService
{

    // ---------- TAREEKA 1: Constructor Injection (BEST PRACTICE) ----------
    private final EmailSender emailSender;

    @Autowired   // ek hi constructor ho to ye likhna optional hai
    public NotificationService(EmailSender emailSender)
    {
        this.emailSender = emailSender;
    }
    // Fayda: field final ho sakti hai, testing easy, object hamesha poora banta hai.

    // ---------- TAREEKA 2: Setter Injection (optional dependency ke liye) ----------
    // private EmailSender emailSender;
    //
    // @Autowired
    // public void setEmailSender(EmailSender emailSender) {
    //     this.emailSender = emailSender;
    // }

    // ---------- TAREEKA 3: Field Injection (short hai par avoid karo) ----------
    // @Autowired
    // private EmailSender emailSender;
    // Nuksan: testing mushkil, final nahi bana sakte.

    public void notifyUser(String msg)
    {
        emailSender.send(msg);   // injected object ka use
    }
}
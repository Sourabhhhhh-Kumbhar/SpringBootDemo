package BasicSpringBoot;

import org.springframework.stereotype.Component;

/*
 * @Component = "Spring, is class ka object tu bana aur apne paas rakh."
 *
 * Normal Java me hum likhte: EmailSender e = new EmailSender();
 * Spring me hume new nahi likhna padta. Spring startup pe khud object
 * banata hai aur container (ApplicationContext) me store karta hai.
 * Is object ko "bean" kehte hain.
 *
 * Kab use karein: jab class kisi specific layer (service/repo/controller)
 * ki na ho, bas ek general helper/utility ho.
 */
@Component
public class EmailSender
{
    public void send(String message)
    {
        System.out.println("Email bheja gaya: " + message);
    }
}
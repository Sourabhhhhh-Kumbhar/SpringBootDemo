package SmallProjectServiceLayer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication: ye class app ka starting point hai.
// Ye apne package (SmallProject) ke andar ki saari classes ko scan karta hai
// aur jahan @Service, @Repository, @RestController likha hai,
// unke objects Spring khud bana deta hai.
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // Yahan se app start hoti hai aur Tomcat server chalu hota hai
        SpringApplication.run(DemoApplication.class, args);
    }
}
package BasicSpringBoot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication = 3 annotations ka combo:
 *   1. @Configuration           -> ye class config class hai, beans define kar sakti hai
 *   2. @EnableAutoConfiguration -> classpath dekh ke Spring khud setup karta hai
 *                                  (Tomcat server, JSON converter, DB config, etc.)
 *   3. @ComponentScan           -> is package aur sub-packages me @Component,
 *                                  @Service, @Repository, @Controller dhundta hai
 *                                  aur unke objects (beans) bana deta hai
 */
@SpringBootApplication
public class DemoApplication
{
    public static void main(String[] args) {
        // Spring container start hota hai, saare beans ban jaate hain,
        // embedded Tomcat server port 8080 pe chalu ho jaata hai
        SpringApplication.run(DemoApplication.class, args);
    }
}
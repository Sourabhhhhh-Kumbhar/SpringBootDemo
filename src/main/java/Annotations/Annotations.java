package Annotations;

//Annotations in Spring Boot are metadata tags you put on classes, methods, or fields to tell Spring how to wire things up, so you write less config and more actual logic. Here are the ones you’ll run into most.
//


//Core / setup
//
//@SpringBootApplication goes on your main class. It’s a combo of @Configuration, @EnableAutoConfiguration, and @ComponentScan.
//@Configuration marks a class that defines beans.
//@Bean goes on a method inside a config class; its return value becomes a Spring-managed bean.
//


//Stereotypes (marking your components)
//
//@Component is the generic “Spring, manage this” annotation.
//@Service is for business logic classes.
//@Repository is for data access classes. It also translates DB exceptions.
//@Controller handles web requests and returns views.
//@RestController is @Controller plus @ResponseBody, so it returns JSON directly.
//


//Dependency injection
//
//@Autowired injects a bean automatically. Constructor injection is preferred these days, and you often don’t even need the annotation if there’s just one constructor.
//@Qualifier picks a specific bean when there are several of the same type.
//@Value("${some.property}") injects values from application.properties.
//


//Web / REST
//
//@RequestMapping maps URLs to classes or methods.
//@GetMapping, @PostMapping, @PutMapping, @DeleteMapping are shortcuts for specific HTTP methods.
//@PathVariable reads values from the URL path (/users/{id}).
//@RequestParam reads query parameters (?name=abc).
//@RequestBody converts the incoming JSON into an object.
//@ResponseStatus sets the HTTP status code.
//@ExceptionHandler and @ControllerAdvice handle exceptions, locally or globally.
//


//Data / JPA
//
//@Entity marks a class as a DB table.
//@Table, @Id, @GeneratedValue, and @Column configure the table name, primary key, ID generation, and columns.
//@OneToMany, @ManyToOne, @ManyToMany, and @JoinColumn define relationships.
//@Transactional wraps a method in a database transaction.
//@Query lets you write a custom query on a repository method.
//


//Validation
//
//@Valid triggers validation.
//@NotNull, @NotBlank, @Size, @Email, @Min, and @Max are the constraint annotations.
//


//Other handy ones
//
//@Profile activates a bean only in certain environments (dev, prod).
//@ConfigurationProperties binds a group of properties to a class.
//@Scheduled runs a method on a schedule (needs @EnableScheduling).
//@Async runs a method asynchronously (needs @EnableAsync).
//@SpringBootTest and @WebMvcTest are for testing.
package corbos.library;

import java.time.format.DateTimeFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@ComponentScan
//@EnableTransactionManagement
@SpringBootApplication 
public class App {

    public static final DateTimeFormatter DateFormatter
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
//        ApplicationContext context
//                = new AnnotationConfigApplicationContext(App.class);
//        Controller controller = context.getBean(Controller.class);
//        controller.run();

    SpringApplication.run(App.class, args);
    }
}

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "sk.stu.fiit.crs")
public class KafkaProducerApplication
{
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }
}

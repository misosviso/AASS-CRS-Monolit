import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dxc.di")
public class KafkaProducerApplication
{
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }
}
package sk.stu.fiit.crs.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties( prefix = "kafka" )
public class KafkaConfigData
{
    private String server;
    private String topic;
    private String groupId;
}

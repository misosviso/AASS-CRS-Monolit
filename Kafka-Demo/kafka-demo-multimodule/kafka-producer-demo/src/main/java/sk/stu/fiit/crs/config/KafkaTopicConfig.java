package sk.stu.fiit.crs.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private static final int NUM_PARTITIONS = 1;
    private static final short REPLICATION_FACTOR = 1;

    @Bean
    public NewTopic waitingReservationsTopic() {
        return TopicBuilder.name("waitingReservations")
                .partitions(NUM_PARTITIONS)
                .replicas(REPLICATION_FACTOR)
                .build();
    }

    @Bean
    public NewTopic completedReservationsTopic() {
        return TopicBuilder.name("completedReservations")
                .partitions(NUM_PARTITIONS)
                .replicas(REPLICATION_FACTOR)
                .build();
    }
}

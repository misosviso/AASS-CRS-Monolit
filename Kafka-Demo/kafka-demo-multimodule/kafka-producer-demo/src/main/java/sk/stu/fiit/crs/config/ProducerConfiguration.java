//package sk.stu.fiit.crs.config;
//
//import sk.stu.fiit.crs.model.Data;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class ProducerConfiguration
//{
//
//    private final KafkaConfigData kafkaConfigData;
//
//    public ProducerConfiguration( KafkaConfigData kafkaConfigData )
//    {
//        this.kafkaConfigData = kafkaConfigData;
//    }
//
//    @Bean
//    public ProducerFactory<String, Data> producerFactory()
//    {
//        Map<String, Object> config = new HashMap<>();
//
//        config.put( ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfigData.getServer() );
//        config.put( ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class );
//        config.put( ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class );
//
//        return new DefaultKafkaProducerFactory<>( config );
//    }
//
//    @Bean
//    public KafkaTemplate<String, Data> kafkaTemplate()
//    {
//        return new KafkaTemplate<>( producerFactory() );
//    }
//}

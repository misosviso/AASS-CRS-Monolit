package com.dxc.di.config;

import com.dxc.di.model.Data;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ConsumerConfiguration
{
    private final KafkaConfigData kafkaConfigData;

    public ConsumerConfiguration( KafkaConfigData kafkaConfigData )
    {
        this.kafkaConfigData = kafkaConfigData;
    }

    @Bean
    public ConsumerFactory<String, Data> dataConsumerFactory()
    {
        Map<String, Object> config = new HashMap<>();

        config.put( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfigData.getServer() );
        config.put( ConsumerConfig.GROUP_ID_CONFIG, kafkaConfigData.getGroupId() );
        config.put( ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class );
        config.put( ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class );
        return new DefaultKafkaConsumerFactory<>( config, new StringDeserializer(),
                new JsonDeserializer<>( Data.class ) );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Data> dataKafkaListenerFactory()
    {
        ConcurrentKafkaListenerContainerFactory<String, Data> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory( dataConsumerFactory() );
        return factory;
    }
}

package com.dxc.di.service;

import com.dxc.di.config.KafkaConfigData;
import com.dxc.di.model.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProducerService
{
    private final KafkaTemplate<String, Data> kafkaTemplate;

    private final KafkaConfigData kafkaConfigData;

    public ProducerService( KafkaTemplate<String, Data> kafkaTemplate, KafkaConfigData kafkaConfigData )
    {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfigData = kafkaConfigData;
    }

    public void sendDataToKafka( Data data )
    {
       log.info( "Sending message to topic with data text: " + data.getText()  + " data number:" +data.getNumber() );
       kafkaTemplate.send( kafkaConfigData.getTopic(), data );
    }
}

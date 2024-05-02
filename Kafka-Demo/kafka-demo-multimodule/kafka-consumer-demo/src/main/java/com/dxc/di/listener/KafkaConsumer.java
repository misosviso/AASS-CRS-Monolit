package com.dxc.di.listener;

import com.dxc.di.model.Data;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer
{

    @KafkaListener( topics = "${kafka.topic}", groupId = "${kafka.group-id}", containerFactory = "dataKafkaListenerFactory" )
    public void consumeJson( Data data )
    {
        System.out.println( "Consumed JSON Message: " + data );
    }
}

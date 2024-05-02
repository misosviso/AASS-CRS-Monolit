package com.dxc.di.controller;

import com.dxc.di.model.Data;
import com.dxc.di.service.ProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController
{

    private final ProducerService producerService;

    public ProducerController( ProducerService producerService )
    {
        this.producerService = producerService;
    }

    @PostMapping( value = "/kafka" )
    public void sendDataToKafka( @RequestBody Data data )
    {
        producerService.sendDataToKafka( data );
    }
}

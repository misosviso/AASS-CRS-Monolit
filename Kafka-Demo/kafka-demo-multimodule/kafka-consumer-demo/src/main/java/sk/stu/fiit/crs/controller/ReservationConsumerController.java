package sk.stu.fiit.crs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stu.fiit.crs.listener.KafkaConsumer;
import sk.stu.fiit.crs.model.Data;

import java.util.List;

@RestController
public class ReservationConsumerController {

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @GetMapping("/waitingReservations")
    public List<Data> getWaitingReservations() {
        return kafkaConsumer.getWaitingReservations();

    }

    @GetMapping("/completedReservations")
    public List<Data> getCompletedReservations() {
        return kafkaConsumer.getCompletedReservations();
    }
}
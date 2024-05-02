package sk.stu.fiit.crs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stu.fiit.crs.listener.KafkaConsumer;

import java.util.List;

@RestController
public class ReservationConsumerController {

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @GetMapping("/waitingReservations")
    public List<String> getWaitingReservations() {
        return kafkaConsumer.getWaitingReservations();

    }

    @GetMapping("/completedReservations")
    public List<String> getCompletedReservations() {
        return kafkaConsumer.getCompletedReservations();
    }
}
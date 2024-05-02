package sk.stu.fiit.crs.listener;

import sk.stu.fiit.crs.model.Data;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {

    private List<String> waitingReservations = new ArrayList<>();
    private List<String> completedReservations = new ArrayList<>();

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.group-id}", containerFactory = "dataKafkaListenerFactory")
    public void consumeJson(Data data) {
        System.out.println("Consumed JSON Message: " + data);
    }

    @KafkaListener(topics = "waitingReservations", groupId = "group_id")
    public void consumeWaitingReservation(String reservation) {
        System.out.println("Received waiting reservation: " + reservation);
        waitingReservations.add(reservation);
    }

    @KafkaListener(topics = "completedReservations", groupId = "group_id")
    public void consumeCompletedReservation(String reservation) {
        System.out.println("Received completed reservation: " + reservation);
        completedReservations.add(reservation);
    }

    public List<String> getWaitingReservations() {
        return waitingReservations;
    }

    public List<String> getCompletedReservations() {
        return completedReservations;
    }

}

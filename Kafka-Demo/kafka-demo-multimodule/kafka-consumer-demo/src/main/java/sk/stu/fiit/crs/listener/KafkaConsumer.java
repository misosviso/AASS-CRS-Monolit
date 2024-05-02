package sk.stu.fiit.crs.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import sk.stu.fiit.crs.model.Data;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {

    @Getter
    private List<Data> waitingReservations = new ArrayList<>();
    @Getter
    private List<Data> completedReservations = new ArrayList<>();

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.group-id}", containerFactory = "dataKafkaListenerFactory")
    public void consumeJson(Data data) {
        System.out.println("Consumed JSON Message: " + data);
    }

    @KafkaListener(topics = "waitingReservations", groupId = "group_id")
    public void consumeWaitingReservation(String reservation) throws JsonProcessingException {
        System.out.println("Received waiting reservation: " + reservation);
        waitingReservations.add(objectMapper.readValue(reservation, Data.class));
    }

    @KafkaListener(topics = "completedReservations", groupId = "group_id")
    public void consumeCompletedReservation(String reservation) throws JsonProcessingException {
        System.out.println("Received completed reservation: " + reservation);
        completedReservations.add(objectMapper.readValue(reservation, Data.class));
    }
}

package sk.stu.fiit.crs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReservationProducerService {

    private static final String WAITING_RESERVATIONS_TOPIC = "waitingReservations";
    private static final String COMPLETED_RESERVATIONS_TOPIC = "completedReservations";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendWaitingReservation(String reservation) {
        kafkaTemplate.send(WAITING_RESERVATIONS_TOPIC, reservation);
    }

    public void sendCompletedReservation(String reservation) {
        kafkaTemplate.send(COMPLETED_RESERVATIONS_TOPIC, reservation);
    }
}

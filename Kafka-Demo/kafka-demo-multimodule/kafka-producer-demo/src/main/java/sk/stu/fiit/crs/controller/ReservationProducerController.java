package sk.stu.fiit.crs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.stu.fiit.crs.model.Data;
import sk.stu.fiit.crs.service.ReservationProducerService;

@RestController
public class ReservationProducerController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ReservationProducerService reservationProducerService;

    @PostMapping("/submitReservation")
    public String submitReservation(@RequestBody Data reservation) throws JsonProcessingException {
        reservationProducerService.sendWaitingReservation(objectMapper.writeValueAsString(reservation));
        return "Reservation submitted successfully!";
    }

    @PostMapping("/confirmReservation")
    public String confirmReservation(@RequestBody Data reservation) throws JsonProcessingException {
        reservationProducerService.sendCompletedReservation(objectMapper.writeValueAsString(reservation));
        return "Reservation submitted successfully!";
    }
}

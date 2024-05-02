package sk.stu.fiit.crs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.stu.fiit.crs.model.Data;
import sk.stu.fiit.crs.service.ReservationProducerService;

@RestController
public class ReservationProducerController {

    @Autowired
    private ReservationProducerService reservationProducerService;

    @PostMapping("/submitReservation")
    public String submitReservation(@RequestBody Data reservation) {
        reservationProducerService.sendWaitingReservation("TEST");
        return "Reservation submitted successfully!";
    }

    @PostMapping("/confirmReservation")
    public String confirmReservation(@RequestBody Data reservation) {
        reservationProducerService.sendCompletedReservation("TEST");
        return "Reservation submitted successfully!";
    }
}

package sk.stu.fiit.reservation.controller;

import sk.stu.fiit.reservation.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @GetMapping
    public List<Reservation> getStudent() {
        System.out.println("getting reservations");
        return Arrays.asList(new Reservation(1,"Miso","123-YYY"),
        new Reservation(2,"Miso","123-XXXX"));
    }

    @PostMapping
    public Boolean createStudent(@RequestBody Reservation reservation) {
        System.out.println("creating reservation:"+ reservation);
        return true;
    }

}

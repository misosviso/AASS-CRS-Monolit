package sk.stu.fiit.aass.crs.controlers;

import org.springframework.web.bind.annotation.GetMapping;

public class AddReservationController {

    @GetMapping("/addReservation")
    public String addReservation() {
        return "addReservation";
    }
}

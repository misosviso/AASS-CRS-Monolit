//package sk.stu.fiit.reservation.controller;
//
//import org.apache.http.HttpException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.web.server.ResponseStatusException;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//import sk.stu.fiit.reservation.model.Reservation;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//
//@RestController
//@RequestMapping("/reservation")
//public class ReservationController {
//
//    private final List<Reservation> reservations = new ArrayList<>();
//
//    @GetMapping
//    public List<Reservation> getStudent(@RequestHeader(value="id") String id, @RequestHeader(value="role") String role) {
//        if (Objects.equals(role, "doctor")) {
//            System.out.println("getting reservations");
//            return reservations;
//        }
//        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
//    }
//
//    @PostMapping
//    public Boolean createStudent(@RequestBody Reservation reservation, @RequestHeader(value="role") String role) {
//        if (Objects.equals(role, "patient")) {
//            System.out.println("getting reservations");
//            reservations.add(reservation);
//        }
//        return true;
//    }
//
//}

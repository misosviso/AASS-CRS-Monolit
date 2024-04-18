package sk.stu.fiit.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.stu.fiit.reservation.models.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByName(String name);
    List<Reservation> findByDate(String date);
}
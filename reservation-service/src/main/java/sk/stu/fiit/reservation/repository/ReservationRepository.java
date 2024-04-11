package sk.stu.fiit.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.stu.fiit.reservation.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
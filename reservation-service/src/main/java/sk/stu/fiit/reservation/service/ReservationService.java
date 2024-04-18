package sk.stu.fiit.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stu.fiit.reservation.models.Reservation;
import sk.stu.fiit.reservation.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllItems() {
        return reservationRepository.findAll();
    }

    public Reservation saveReservation(Reservation item){
        return reservationRepository.save(item);
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public boolean dateFree(String date) {
        return reservationRepository.findByDate(date).isEmpty();
    }

    public Reservation confirmReservation(String name) {
        List<Reservation> reservations = reservationRepository.findByName(name);

        if (!reservations.isEmpty()) {
            Reservation reservation = reservations.get(0);
            reservation.setName(name);
            reservation.setConfirmed(true);
            // You can update other properties as needed

            return reservationRepository.save(reservation);
        } else {
            // Handle the case when the reservation with the given id is not found
            throw new IllegalArgumentException("Reservation not found with id: " + name);
        }
    }
}
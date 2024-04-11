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

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);

        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            reservation.setName(updatedReservation.getName());
            // You can update other properties as needed

            return reservationRepository.save(reservation);
        } else {
            // Handle the case when the reservation with the given id is not found
            throw new IllegalArgumentException("Reservation not found with id: " + id);
        }
    }
}
package alessiovulpinari.u2_w1_d5_Java.services;

import alessiovulpinari.u2_w1_d5_Java.entities.Reservation;
import alessiovulpinari.u2_w1_d5_Java.exceptions.AlreadyExistingReservationException;
import alessiovulpinari.u2_w1_d5_Java.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


    public void saveReservation(Reservation newReservation) {

        if (newReservation.getReservationDate().isBefore(LocalDate.now())) throw new RuntimeException("Devi inserire una data che sia successiva alla data odierna!");

        if (reservationRepository.existsByReservationDateAndWorkStation(newReservation.getReservationDate(), newReservation.getWorkStation())) {
            throw new AlreadyExistingReservationException(newReservation.getReservationDate(), newReservation.getWorkStation().getBuilding().getName());
        }

        if (reservationRepository.existsByReservationDateAndUser(newReservation.getReservationDate(), newReservation.getUser())) {
            throw new RuntimeException("Hai già una prenotazione per questa data: " + newReservation.getReservationDate());
        }

        reservationRepository.save(newReservation);

        System.out.println("La prenotazione del " + newReservation.getReservationDate() +
                " a: " + newReservation.getWorkStation().getBuilding().getName() + " è stata confermata!");
    }
}

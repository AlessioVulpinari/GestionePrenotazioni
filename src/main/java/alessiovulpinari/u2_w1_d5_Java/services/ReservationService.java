package alessiovulpinari.u2_w1_d5_Java.services;

import alessiovulpinari.u2_w1_d5_Java.entities.Reservation;
import alessiovulpinari.u2_w1_d5_Java.exceptions.AlredyExistingReservationException;
import alessiovulpinari.u2_w1_d5_Java.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


    public void saveReservation(Reservation newReservation) {

        if (reservationRepository.existsByReservationDateAndWorkStation(newReservation.getReservationDate(), newReservation.getWorkStation())) {
            throw new AlredyExistingReservationException(newReservation.getReservationDate(), newReservation.getWorkStation().getBuilding().getName());
        }

        if (newReservation.getReservationDate().isBefore(LocalDate.now())) throw new RuntimeException("Devi inserire una data che sia successiva alla data odierna!");

        reservationRepository.save(newReservation);

        System.out.println("La prenotazione del " + newReservation.getReservationDate() +
                " a: " + newReservation.getWorkStation().getBuilding().getName() + " è stata confermata!");
    }
}

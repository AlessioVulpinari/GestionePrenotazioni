package alessiovulpinari.u2_w1_d5_Java.repositories;

import alessiovulpinari.u2_w1_d5_Java.entities.Reservation;
import alessiovulpinari.u2_w1_d5_Java.entities.User;
import alessiovulpinari.u2_w1_d5_Java.entities.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    /* Query per verificare l'esistenza di una prenotazione con una determinata data di prenotazione
    e per un determinata locazione. */
    boolean existsByReservationDateAndWorkStation (LocalDate date, WorkStation workStation);

    // Query per verificare l'esistenza di una prenotazione di un utente a una determinata data
    boolean existsByReservationDateAndUser(LocalDate date, User user);

}

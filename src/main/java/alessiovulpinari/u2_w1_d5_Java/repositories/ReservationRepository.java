package alessiovulpinari.u2_w1_d5_Java.repositories;

import alessiovulpinari.u2_w1_d5_Java.entities.Reservation;
import alessiovulpinari.u2_w1_d5_Java.entities.User;
import alessiovulpinari.u2_w1_d5_Java.entities.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    boolean existsByReservationDateAndWorkStation (LocalDate date, WorkStation workStation);

    boolean existsByReservationDateAndUser(LocalDate date, User user);

}

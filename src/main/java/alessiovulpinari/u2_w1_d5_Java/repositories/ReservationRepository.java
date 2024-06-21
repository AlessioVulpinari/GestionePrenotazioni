package alessiovulpinari.u2_w1_d5_Java.repositories;

import alessiovulpinari.u2_w1_d5_Java.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
}

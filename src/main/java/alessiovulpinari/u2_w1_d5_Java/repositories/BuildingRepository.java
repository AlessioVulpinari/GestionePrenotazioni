package alessiovulpinari.u2_w1_d5_Java.repositories;

import alessiovulpinari.u2_w1_d5_Java.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {

    // Verifica l'esistenza di un edificio con un determinato nome e un determinato indirizzo
    boolean existsByAddressAndName(String address, String name);
}

package alessiovulpinari.u2_w1_d5_Java.repositories;

import alessiovulpinari.u2_w1_d5_Java.entities.WorkStation;
import alessiovulpinari.u2_w1_d5_Java.enums.WorkStationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkStationRepository extends JpaRepository<WorkStation, UUID> {

    // Query personalizzata per cercare le postazione di un determinato tipo, il cui edificio si trova in una determinata città
    @Query("SELECT w FROM WorkStation w WHERE w.workStationType = :workStationType AND w.building.city = :city")
    List<WorkStation> searchByCityAndStationType(WorkStationType workStationType, String city);
}

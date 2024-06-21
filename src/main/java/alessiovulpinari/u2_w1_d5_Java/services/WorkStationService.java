package alessiovulpinari.u2_w1_d5_Java.services;

import alessiovulpinari.u2_w1_d5_Java.entities.Building;
import alessiovulpinari.u2_w1_d5_Java.entities.WorkStation;
import alessiovulpinari.u2_w1_d5_Java.enums.WorkStationType;
import alessiovulpinari.u2_w1_d5_Java.exceptions.ToShortException;
import alessiovulpinari.u2_w1_d5_Java.repositories.WorkStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkStationService {

    @Autowired
    private WorkStationRepository workStationRepository;

    public void saveWorkStation(WorkStation newWorkStation) {

        if (newWorkStation.getDescription().length() <= 5) throw new ToShortException(newWorkStation.getDescription());

        workStationRepository.save(newWorkStation);

        System.out.println("Salvata la nuova postazione: " + newWorkStation.getDescription() +
                " dell'edificio " + newWorkStation.getBuilding().getName());
    }

    public WorkStation findById(String id) {
        return workStationRepository.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException("Nessuna postazione trovato!"));
    }

    public List<WorkStation> searchByCityAndStationType(WorkStationType workStationType, String city) {
      return workStationRepository.searchByCityAndStationType(workStationType, city);
    }

}

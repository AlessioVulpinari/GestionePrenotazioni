package alessiovulpinari.u2_w1_d5_Java.services;

import alessiovulpinari.u2_w1_d5_Java.entities.Building;
import alessiovulpinari.u2_w1_d5_Java.exceptions.AlredyExistingBuildingExp;
import alessiovulpinari.u2_w1_d5_Java.exceptions.ToShortException;
import alessiovulpinari.u2_w1_d5_Java.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public void saveBuilding(Building newBuilding) {

        if (buildingRepository.existsByAddressAndName(newBuilding.getAddress(), newBuilding.getName())) {
            throw new AlredyExistingBuildingExp(newBuilding.getName(), newBuilding.getAddress());
        }

        if (newBuilding.getName().length() <= 3 ) throw new ToShortException(newBuilding.getName());

        buildingRepository.save(newBuilding);

        System.out.println("L'edificio con id: " + newBuilding.getBuildingId() + " è stato aggiunto con successo!");
    }

    public Building findById(String id) {
        return buildingRepository.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException("Nessun edificio trovato!"));
    }
}

package alessiovulpinari.u2_w1_d5_Java.services;

import alessiovulpinari.u2_w1_d5_Java.entities.WorkStation;
import alessiovulpinari.u2_w1_d5_Java.repositories.WorkStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkStationService {

    @Autowired
    private WorkStationRepository workStationRepository;
}

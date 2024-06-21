package alessiovulpinari.u2_w1_d5_Java.runners;

import alessiovulpinari.u2_w1_d5_Java.services.BuildingService;
import alessiovulpinari.u2_w1_d5_Java.services.ReservationService;
import alessiovulpinari.u2_w1_d5_Java.services.UserService;
import alessiovulpinari.u2_w1_d5_Java.services.WorkStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainRunner implements CommandLineRunner {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @Autowired
    private WorkStationService workStationService;

    @Override
    public void run(String... args) throws Exception {

    }
}

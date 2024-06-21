package alessiovulpinari.u2_w1_d5_Java.runners;

import alessiovulpinari.u2_w1_d5_Java.entities.Building;
import alessiovulpinari.u2_w1_d5_Java.entities.Reservation;
import alessiovulpinari.u2_w1_d5_Java.entities.User;
import alessiovulpinari.u2_w1_d5_Java.entities.WorkStation;
import alessiovulpinari.u2_w1_d5_Java.enums.WorkStationType;
import alessiovulpinari.u2_w1_d5_Java.services.BuildingService;
import alessiovulpinari.u2_w1_d5_Java.services.ReservationService;
import alessiovulpinari.u2_w1_d5_Java.services.UserService;
import alessiovulpinari.u2_w1_d5_Java.services.WorkStationService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

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

        Random random = new Random();
        Faker faker = new Faker(Locale.ITALY);
        Building building = new Building(faker.company().name() , faker.address().fullAddress(), faker.address().cityName() );

       // buildingService.saveBuilding(building);

        WorkStation workStation = new WorkStation(buildingService.findById("d0b6b70e-21ae-4a1c-8d68-2fd504e72866"), random.nextInt(100, 1000), WorkStationType.MEETING_ROOM, faker.lorem().sentence());
       // workStationService.saveWorkStation(workStation);

        User user = new User(faker.dragonBall().character(), faker.name().fullName(), faker.internet().emailAddress());
       // userService.saveUser(user);

        Reservation reservation = new Reservation(LocalDate.now().plusDays(3), userService.findById("6a1eed02-3932-4bce-8e8c-3ba5400a4055"), workStationService.findById("4c53beba-8511-448a-958c-4d941633f998") );

//        try {
//            reservationService.saveReservation(reservation);
//        } catch (RuntimeException err) {
//            System.out.println(err.getMessage());
//        }

        List<WorkStation> workStations = workStationService.searchByCityAndStationType(WorkStationType.MEETING_ROOM, "Krajciktown");

         workStations.forEach(System.out::println);

    }
}

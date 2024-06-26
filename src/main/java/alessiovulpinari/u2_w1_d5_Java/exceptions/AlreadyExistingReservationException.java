package alessiovulpinari.u2_w1_d5_Java.exceptions;

import java.time.LocalDate;

public class AlreadyExistingReservationException extends RuntimeException{
   public AlreadyExistingReservationException(LocalDate date, String location) {
       super("Esiste già una prenotazione a questa data: " + date + " in questo edificiO: " + location);
   }
}

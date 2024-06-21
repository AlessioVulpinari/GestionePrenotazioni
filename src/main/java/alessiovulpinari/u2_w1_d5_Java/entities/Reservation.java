package alessiovulpinari.u2_w1_d5_Java.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "prenotazioni")
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "prenotazione_id", nullable = false)
    private UUID reservationId;

    @Column(name = "data_prenotazione", nullable = false)
    private LocalDate reservationDate;

    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_postazione", nullable = false)
    private WorkStation workStation;

    public Reservation(LocalDate reservationDate, User user, WorkStation workStation) {
        this.reservationDate = reservationDate;
        this.user = user;
        this.workStation = workStation;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", reservationDate=" + reservationDate +
                ", user=" + user +
                ", workStation=" + workStation +
                '}';
    }
}

package alessiovulpinari.u2_w1_d5_Java.entities;

import alessiovulpinari.u2_w1_d5_Java.enums.WorkStationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "postazioni")
public class WorkStation {

    @Id
    @GeneratedValue
    @Column(name = "id_postazione", nullable = false)
    private UUID workStationId;

    @Column(name = "descrizione", nullable = false)
    private String description;

    @Column(name = "tipo_postazione", nullable = false)
    private WorkStationType workStationType;

    @Column(name = "massimo_persone", nullable = false)
    private int maxPerson;

    @OneToMany(mappedBy = "workStation")
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Building building;

    public WorkStation(Building building, int maxPerson, WorkStationType workStationType, String description, UUID workStationId) {
        this.building = building;
        this.maxPerson = maxPerson;
        this.workStationType = workStationType;
        this.description = description;
        this.workStationId = workStationId;
    }

    @Override
    public String toString() {
        return "WorkStation{" +
                "workStationId=" + workStationId +
                ", description='" + description + '\'' +
                ", workStationType=" + workStationType +
                ", maxPerson=" + maxPerson +
                ", building=" + building +
                '}';
    }
}

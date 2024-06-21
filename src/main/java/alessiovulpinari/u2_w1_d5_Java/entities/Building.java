package alessiovulpinari.u2_w1_d5_Java.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "edifici")
public class Building {

    @Id
    @GeneratedValue
    @Column(name = "id_edificio", nullable = false)
    private UUID buildingId;

    @Column(name = "nome_edificio", nullable = false)
    private String name;

    @Column(name = "indirizzo", nullable = false)
    private String address;

    @Column(name = "citta", nullable = false)
    private String city;

    @OneToMany(mappedBy = "building")
    private List<WorkStation> workStations;

    public Building(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingId=" + buildingId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

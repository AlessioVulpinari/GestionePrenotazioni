package alessiovulpinari.u2_w1_d5_Java.entities;

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
@Table(name = "utenti")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id_utente", nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String username;

    @Column(name = "nome_completo", nullable = false)
    private String completeName;

    @Column(name = "indirizzo_di_posta_elettronica", nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    public User(String username, String completeName, String email) {
        this.username = username;
        this.completeName = completeName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", completeName='" + completeName + '\'' +
                ", username='" + username + '\'' +
                ", userId=" + userId +
                '}';
    }
}

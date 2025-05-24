package ro.ubbcluj.core.Model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "cerere")
@IdClass(CererePK.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Cerere implements Serializable {
    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "locatar_id")
    private Locatar locatar;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "angajat_id")
    private Angajat angajat;

    @Column(name = "problema")
    private String problema;

    @Column(name = "categorie")
    private Specializare categorie;

    @Column(name = "status")
    private Boolean status;

    @Override
    public String toString() {
        return "Cerere{" +
                "locatar=" + locatar +
                ", angajat=" + angajat +
                ", problema='" + problema + '\'' +
                ", categorie=" + categorie +
                ", status=" + status +
                '}';
    }
}
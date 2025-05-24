package ro.ubbcluj.core.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Angajat extends BaseEntity<Long>{
//    private String nume;
//    private Integer salariu;
//    private Specializare specializare;
//    private Boolean disponibilitate;
//    private Boolean contValidat;
//
//    public Angajat(Angajat angajat) {
//        super();
//    }

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salariu", nullable = false)
    private Integer salariu;

    @Column(name = "specializare", nullable = false)
    private Specializare specializare;

    @Column(name = "disponibilitate", nullable = false)
    private Boolean disponibilitate;

    @Column(name = "contValidat", nullable = false)
    private Boolean contValidat;

    @OneToMany(mappedBy = "angajat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Cerere> cereri= new HashSet<>();

    public Set<Angajat> getAngajati() {
        cereri = cereri == null ? new HashSet<>() :
                cereri;
        return Collections.unmodifiableSet(
                this.cereri.stream().
                        map(Cerere::getAngajat).
                        collect(Collectors.toSet()));
    }

}


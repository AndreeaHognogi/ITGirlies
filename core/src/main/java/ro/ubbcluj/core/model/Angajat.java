package ro.ubbcluj.core.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Angajat extends BaseEntity<Long>{

    @Column(name = "name", nullable = false)
    private String nume;

    @Column(name = "salariu", nullable = false)
    private Integer salariu;

    @Column(name = "specializare", nullable = false)
    @Enumerated(EnumType.STRING)
    private Specializare specializare;

    @Column(name = "disponibilitate", nullable = false)
    private Boolean disponibilitate;

    @Column(name = "contValidat", nullable = false)
    private Boolean contValidat;


    @OneToMany(mappedBy = "angajat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Cerere> cereri= new HashSet<>();

    public Angajat(Long id){
        super(id);
    }
//    public Set<Angajat> getAngajati() {
//        cereri = cereri == null ? new HashSet<>() :
//                cereri;
//        return Collections.unmodifiableSet(
//                this.cereri.stream().
//                        map(Cerere::getAngajat).
//                        collect(Collectors.toSet()));
//    }

}


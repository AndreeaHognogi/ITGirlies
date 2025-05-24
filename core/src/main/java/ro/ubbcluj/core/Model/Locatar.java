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
public class Locatar extends BaseEntity<Long> {
//    private String nume;
//    private Integer numarCamera;
//    private Boolean contValidat;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "numarCamera", nullable = false)
    private Integer numarCamera;

    @Column(name = "contValidat", nullable = false)
    private Boolean contValidat;

    @OneToMany(mappedBy = "locatar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private Set<Cerere> cerere = new HashSet<>();

    public Set<Locatar> getLocatari() {
        return Collections.unmodifiableSet(
                cerere.stream()
                        .map(Cerere::getLocatar)
                        .collect(Collectors.toSet())
        );

//    public Locatar(Locatar locatar) {
//        super();
//    }
    }
}

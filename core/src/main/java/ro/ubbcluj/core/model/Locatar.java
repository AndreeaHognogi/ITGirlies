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
@ToString
@Builder
public class Locatar extends BaseEntity<Long> {

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "numarCamera", nullable = false)
    private Integer numarCamera;

    @Column(name = "contValidat", nullable = false)
    private Boolean contValidat;

    @OneToMany(mappedBy = "locatar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cerere> cerere = new HashSet<>();


    public Locatar(Long id) {
        super(id);
    }
//    public Set<Locatar> getLocatari() {
//        return Collections.unmodifiableSet(
//                cerere.stream()
//                        .map(Cerere::getLocatar)
//                        .collect(Collectors.toSet())
//        );

}

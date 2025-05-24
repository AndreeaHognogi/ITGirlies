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
public class Administrator extends BaseEntity<Long>{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Cerere> cereri= new HashSet<>();

    public Set<Locatar> getLocatari() {
        cereri = cereri == null ? new HashSet<>() :
                cereri;
        return Collections.unmodifiableSet(
                this.cereri.stream().
                        map(Cerere::getLocatar).
                        collect(Collectors.toSet()));
    }
}

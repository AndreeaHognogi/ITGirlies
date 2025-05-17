package ro.ubbcluj.core.Model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
@ToString
@Builder
public class Angajat extends BaseEntity<Long>{
    private String nume;
    private Integer salariu;
    private Specializare specializare;
    private Boolean disponibilitate;
    private Boolean contValidat;
}

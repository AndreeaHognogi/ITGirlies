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
public class Locatar extends BaseEntity<Long>{
    private String nume;
    private Integer numarCamera;
    private Boolean contValidat;
}

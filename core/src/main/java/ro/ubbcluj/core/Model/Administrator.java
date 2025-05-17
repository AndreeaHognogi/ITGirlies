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
public class Administrator extends BaseEntity<Long>{
    private String nume;
}

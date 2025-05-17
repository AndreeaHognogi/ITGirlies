package ro.ubbcluj.core.Model;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CererePK implements Serializable {
    private Locatar locatar;
    private Angajat angajat;
}

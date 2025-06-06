package ro.ubbcluj.web.dto;

import lombok.*;
import ro.ubbcluj.core.model.Specializare;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AngajatDto extends BaseDto{
    private String nume;
    private Integer salariu;
    private Specializare specializare;
    private Boolean disponibilitate;
    private Boolean contValidat;
}

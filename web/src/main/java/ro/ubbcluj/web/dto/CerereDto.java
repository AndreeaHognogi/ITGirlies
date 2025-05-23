package ro.ubbcluj.web.dto;

import lombok.*;
import ro.ubbcluj.core.Model.Angajat;
import ro.ubbcluj.core.Model.Locatar;
import ro.ubbcluj.core.Model.Specializare;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CerereDto {
    private Locatar locatar;
    private Angajat angajat;
    private String problema;
    private Specializare categorie;
    private Boolean status;

}

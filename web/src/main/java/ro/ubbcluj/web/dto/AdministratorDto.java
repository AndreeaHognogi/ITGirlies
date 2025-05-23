package ro.ubbcluj.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AdministratorDto extends BaseDto{
    private String nume;
}

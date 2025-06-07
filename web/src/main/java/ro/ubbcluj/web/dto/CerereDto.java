package ro.ubbcluj.web.dto;

import lombok.*;
import ro.ubbcluj.core.model.Status;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CerereDto extends BaseDto{
    private String subiect;
    private String descriere;
    private LocalDate data;
    private Status status;

}

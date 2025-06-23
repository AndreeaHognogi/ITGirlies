package ro.ubbcluj.web.dto;

import lombok.*;
import ro.ubbcluj.core.model.Status;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CerereDto extends BaseDto{
    private String subiect;
    private String descriere;
    private String data;
    private Status status;

}

package ro.ubbcluj.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ro.ubbcluj.core.model.Status;
import ro.ubbcluj.core.model.User;

import java.time.LocalDate;
import java.util.Date;


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

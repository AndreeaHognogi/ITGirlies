package ro.ubbcluj.core.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Cerere extends BaseEntity<Long> {

    @Column(name = "subiect")
    private String subiect;

    @Column(name = "descriere")
    private String descriere;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Cerere(Long id){
        super(id);
    }
}

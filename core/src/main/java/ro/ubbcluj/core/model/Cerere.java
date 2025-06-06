package ro.ubbcluj.core.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@IdClass(CererePK.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "cerere")
public class Cerere extends BaseEntity<Long> {
    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "locatar_id")
    private Locatar locatar;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "angajat_id")
    private Angajat angajat;

    @Column(name = "problema")
    private String problema;

    @Column(name = "specializare", nullable = false)
    @Enumerated(EnumType.STRING)
    private Specializare specializare;

    @Column(name = "status")
    private Boolean status;

    public Cerere(Long id){
        super(id);
    }
}

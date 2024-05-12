package com.uptc.frmw.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PARTICIPANTES")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "participantGen")
    @SequenceGenerator(name="participantGen", sequenceName = "PARTICIPACION_SEQ", allocationSize = 1)
    @Column(name="ID_PARTICIPACION")
    private Long idParticipant;

    @Column(name="EDICION_ID", insertable = false, updatable = false)
    private int idEdition;

    @Column(name="EQUIPO_ID", insertable = false, updatable = false)
    private Long idTeam;

    @Column(name="PATROCINADOR_ID", insertable = false, updatable = false)
    private String idSponsor;

    @ManyToOne
    @JoinColumn(name="EDICION_ID", nullable = false)
    private Edition edition;

    @ManyToOne
    @JoinColumn(name="PATROCINADOR_ID", nullable = false)
    private Sponsor sponsor;

    @ManyToOne
    @JoinColumn(name="EQUIPO_ID", nullable = false)
    private Team team;

    public Participant() {
    }

    public Participant(Long idParticipant, int idEdition, Long idTeam, String idSponsor) {
        this.idParticipant = idParticipant;
        this.idEdition = idEdition;
        this.idTeam = idTeam;
        this.idSponsor = idSponsor;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "idParticipant=" + idParticipant +
                ", idEdition=" + idEdition +
                ", idTeam=" + idTeam +
                ", idSponsor='" + idSponsor + '\'' +
                '}';
    }
}

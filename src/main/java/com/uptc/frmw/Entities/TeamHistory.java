package com.uptc.frmw.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "HISTORIAL_EQUIPOS")
public class TeamHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historialGen")
    @SequenceGenerator(name="historialGen", sequenceName = "HISTORIAL_SEQ", allocationSize = 1)
    @Column(name="ID_HISTORIAL")
    private Long idHistory;

    @Column(name="EQUIPO_ID", insertable = false, updatable = false)
    private Long idTeam;

    @Column(name="CORREDOR_ID", insertable = false, updatable = false)
    private Long idRunner;

    @Column(name="EDICION_ID", insertable = false, updatable = false)
    private short idEdition;

    @Column(name="FECHA_INGRESO")
    private Date dateAdmission;

    @ManyToOne
    @JoinColumn(name="EDICION_ID", nullable = false)
    private Edition edition;

    @ManyToOne
    @JoinColumn(name="EQUIPO_ID", nullable = false)
    private Team team;

    @ManyToOne
    @JoinColumn( name="CORREDOR_ID", nullable = false)
    private Runner runner;

    public TeamHistory() {
    }

    public TeamHistory(Long idHistory, Date dateAdmission, Long idTeam, short idEdition, Long idRunner) {
        this.idHistory = idHistory;
        this.dateAdmission = dateAdmission;
        this.idTeam = idTeam;
        this.idEdition = idEdition;
        this.idRunner = idRunner;
    }

    @Override
    public String toString() {
        return "TeamHistory{" +
                "idHistory=" + idHistory +
                ", dateAdmission=" + dateAdmission +
                ", idTeam=" + idTeam +
                ", idRunner=" + idRunner +
                ", idEdition=" + idEdition +
                '}';
    }
}

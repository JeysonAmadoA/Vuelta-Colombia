package com.uptc.frmw.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PODIOS")
public class Podium {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "podiumGen")
    @SequenceGenerator(name="podiumGen", sequenceName = "PODIO_SEQ", allocationSize = 1)
    @Column(name="ID_PODIO")
    private Long idPodium;

    @Column(name="CORREDOR_ID", insertable = false, updatable = false)
    private Long idRunner;
    @Column(name="ETAPA_ID", insertable = false, updatable = false)
    private Long idStage;

    @Column(name="PUESTO")
    private short position;
    @Column(name="TIEMPO_MINUTOS")
    private int timeMinutes;

    @ManyToOne
    @JoinColumn(name="CORREDOR_ID", nullable = false)
    private Runner runner;

    @ManyToOne
    @JoinColumn(name="ETAPA_ID", nullable = false)
    private Stage stage;

    public Podium() {
    }

    public Podium(Long idPodium, short position, int timeMinutes, Long idRunner, Long idStage) {
        this.idPodium = idPodium;
        this.position = position;
        this.timeMinutes = timeMinutes;
        this.idRunner = idRunner;
        this.idStage = idStage;
    }

    @Override
    public String toString() {
        return "Podium{" +
                "idPodium=" + idPodium +
                ", position=" + position +
                ", timeMinutes=" + timeMinutes +
                ", idRunner=" + idRunner +
                ", idStage=" + idStage +
                '}';
    }
}

package com.uptc.frmw.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ETAPAS")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stageGen")
    @SequenceGenerator(name="stageGen", sequenceName = "ETAPAS_SEQ", allocationSize = 1)
    @Column(name="ID_ETAPA")
    private Long idStage;

    @Column(name="ORIGEN")
    private String origin;

    @Column(name="DESTINO")
    private String destination;

    @Column(name="LONGITUD")
    private double longitude;

    @Column(name="TIPO_ETAPA")
    private String typeStage;


    @Column(name="EDICION_ID", insertable = false, updatable = false)
    private int idEdition;

    @ManyToOne
    @JoinColumn(name="EDICION_ID")
    private Edition edition;

    @OneToMany(mappedBy = "stage")
    @JsonIgnore
    private List<Podium> podiumList;

    public Stage() {
    }

    public Stage(Long idStage, String origin, double longitude, String destination, int idEdition, String typeStage) {
        this.idStage = idStage;
        this.origin = origin;
        this.longitude = longitude;
        this.destination = destination;
        this.idEdition = idEdition;
        this.typeStage = typeStage;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "idStage=" + idStage +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", longitude=" + longitude +
                ", typeStage='" + typeStage + '\'' +
                ", idEdition=" + idEdition +
                '}';
    }
}

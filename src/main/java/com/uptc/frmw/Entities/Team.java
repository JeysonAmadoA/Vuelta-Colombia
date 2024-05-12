package com.uptc.frmw.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "EQUIPOS")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamGen")
    @SequenceGenerator(name="teamGen", sequenceName = "EQUIPO_SEQ", allocationSize = 1)
    @Column(name="ID_EQUIPO")
    private Long idTeam;

    @Column(name="NOMBRE_EQUIPO")
    private String nameTeam;

    @Column(name="FECHA_FUNDACION")
    private Date dateFundation;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Participant> participantList;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<TeamHistory> teamHistoryList;

    public Team() {
    }

    public Team(Long idTeam, String nameTeam, Date dateFundation) {
        this.idTeam = idTeam;
        this.nameTeam = nameTeam;
        this.dateFundation = dateFundation;
    }


    @Override
    public String toString() {
        return "Team{" +
                "idTeam=" + idTeam +
                ", nameTeam='" + nameTeam + '\'' +
                ", dateFundation=" + dateFundation +
                '}';
    }
}

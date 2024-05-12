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
@Table(name = "CORREDORES")
public class Runner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "runnerGen")
    @SequenceGenerator(name="runnerGen", sequenceName = "CORREDOR_SEQ", allocationSize = 1)
    @Column(name="ID_CORREDOR")
    private Long idRunner;

    @Column(name="NOMBRE_CORREDOR")
    private String nameRunner;

    @Column(name="PAIS_NACIMIENTO")
    private String countryBirth;

    @Column(name="FECHA_NACIMIENTO")
    private Date dateBirth;

    @OneToMany(mappedBy = "runner")
    @JsonIgnore
    private List<TeamHistory> teamHistoryList;

    @OneToMany(mappedBy = "runner" )
    @JsonIgnore
    private List<Podium> podiumsList;

    public Runner() {
    }

    public Runner(Long idRunner, String nameRunner, String countryBirth, Date dateBirth) {
        this.idRunner = idRunner;
        this.nameRunner = nameRunner;
        this.countryBirth = countryBirth;
        this.dateBirth = dateBirth;
    }


    @Override
    public String toString() {
        return "Runner{" +
                "idRunner=" + idRunner +
                ", nameRunner='" + nameRunner + '\'' +
                ", countryBirth='" + countryBirth + '\'' +
                ", dateBirth=" + dateBirth +
                '}';
    }
}

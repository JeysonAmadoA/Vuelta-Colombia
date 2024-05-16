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
@Table(name = "EDICIONES")
public class Edition {

    @Id
    @Column(name="ANIO")
    private short anio;

    @Column(name="FECHA_INICIAL")
    private Date startDate;

    @Column(name="FECHA_FINAL")
    private Date endDate;

    @OneToMany(mappedBy = "edition" )
    @JsonIgnore
    private List<Stage> stages;

    @OneToMany(mappedBy = "edition")
    @JsonIgnore
    private List<Participant> participants;

    @OneToMany(mappedBy = "edition")
    @JsonIgnore
    private List<TeamHistory> teamHistoryList;

    public Edition() {
    }

    public Edition(short anio, Date startDate, Date endDate) {
        this.anio = anio;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "año=" + anio +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

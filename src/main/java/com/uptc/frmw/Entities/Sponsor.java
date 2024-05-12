package com.uptc.frmw.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PATROCINADORES")
public class Sponsor {

    @Id
    @Column(name="NIT")
    private String nit;

    @Column(name="NOMBRE_PATROCINADOR")
    private String nameSponsor;

    @OneToMany(mappedBy = "sponsor")
    @JsonIgnore
    private List<Participant> participantsList;



    public Sponsor() {
    }

    public Sponsor(String nit, String nameSponsor) {
        this.nit = nit;
        this.nameSponsor = nameSponsor;
    }


    @Override
    public String toString() {
        return "Sponsor{" +
                "nit='" + nit + '\'' +
                ", nameSponsor='" + nameSponsor + '\'' +
                '}';
    }
}

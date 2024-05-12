package com.uptc.frmw.Entities;

import java.sql.Date;

public class Team {

    private Long idTeam;
    private String nameTeam;
    private Date dateFundation;

    public Team() {
    }

    public Team(Long idTeam, String nameTeam, Date dateFundation) {
        this.idTeam = idTeam;
        this.nameTeam = nameTeam;
        this.dateFundation = dateFundation;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public Date getDateFundation() {
        return dateFundation;
    }

    public void setDateFundation(Date dateFundation) {
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

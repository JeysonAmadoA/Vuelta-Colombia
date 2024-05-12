package com.uptc.frmw.Entities;

import java.sql.Date;

public class TeamHistory {

    private Long idHistory;
    private Date dateAdmission;

    private Long idTeam;
    private Long idRunner;
    private int idEdition;

    public TeamHistory() {
    }

    public TeamHistory(Long idHistory, Date dateAdmission, Long idTeam, int idEdition, Long idRunner) {
        this.idHistory = idHistory;
        this.dateAdmission = dateAdmission;
        this.idTeam = idTeam;
        this.idEdition = idEdition;
        this.idRunner = idRunner;
    }

    public Long getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(Long idHistory) {
        this.idHistory = idHistory;
    }

    public Date getDateAdmission() {
        return dateAdmission;
    }

    public void setDateAdmission(Date dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public Long getIdRunner() {
        return idRunner;
    }

    public void setIdRunner(Long idRunner) {
        this.idRunner = idRunner;
    }

    public int getIdEdition() {
        return idEdition;
    }

    public void setIdEdition(int idEdition) {
        this.idEdition = idEdition;
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

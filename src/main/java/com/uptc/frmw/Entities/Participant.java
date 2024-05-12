package com.uptc.frmw.Entities;

public class Participant {

    private Long idParticipant;
    private int idEdition;
    private Long idTeam;
    private String idSponsor;

    public Participant() {
    }

    public Participant(Long idParticipant, int idEdition, Long idTeam, String idSponsor) {
        this.idParticipant = idParticipant;
        this.idEdition = idEdition;
        this.idTeam = idTeam;
        this.idSponsor = idSponsor;
    }

    public Long getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(Long idParticipant) {
        this.idParticipant = idParticipant;
    }

    public int getIdEdition() {
        return idEdition;
    }

    public void setIdEdition(int idEdition) {
        this.idEdition = idEdition;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public String getIdSponsor() {
        return idSponsor;
    }

    public void setIdSponsor(String idSponsor) {
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

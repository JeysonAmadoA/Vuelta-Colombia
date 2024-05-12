package com.uptc.frmw.Entities;

public class Podium {

    private Long idPodium;
    private int position;
    private int timeMinutes;

    private Long idRunner;
    private Long idStage;

    public Podium() {
    }

    public Podium(Long idPodium, int position, int timeMinutes, Long idRunner, Long idStage) {
        this.idPodium = idPodium;
        this.position = position;
        this.timeMinutes = timeMinutes;
        this.idRunner = idRunner;
        this.idStage = idStage;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Long getIdPodium() {
        return idPodium;
    }

    public void setIdPodium(Long idPodium) {
        this.idPodium = idPodium;
    }

    public int getTimeMinutes() {
        return timeMinutes;
    }

    public void setTimeMinutes(int timeMinutes) {
        this.timeMinutes = timeMinutes;
    }

    public Long getIdRunner() {
        return idRunner;
    }

    public void setIdRunner(Long idRunner) {
        this.idRunner = idRunner;
    }

    public Long getIdStage() {
        return idStage;
    }

    public void setIdStage(Long idStage) {
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

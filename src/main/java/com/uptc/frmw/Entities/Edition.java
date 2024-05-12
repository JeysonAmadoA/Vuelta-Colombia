package com.uptc.frmw.Entities;
import java.sql.Date;
public class Edition {

    private int anio;
    private Date startDate;
    private Date endDate;

    public Edition() {
    }

    public Edition(int anio, Date startDate, Date endDate) {
        this.anio = anio;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "anio=" + anio +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

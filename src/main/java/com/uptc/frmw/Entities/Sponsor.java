package com.uptc.frmw.Entities;

public class Sponsor {

    private String nit;
    private String nameSponsor;

    public Sponsor() {
    }

    public Sponsor(String nit, String nameSponsor) {
        this.nit = nit;
        this.nameSponsor = nameSponsor;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNameSponsor() {
        return nameSponsor;
    }

    public void setNameSponsor(String nameSponsor) {
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

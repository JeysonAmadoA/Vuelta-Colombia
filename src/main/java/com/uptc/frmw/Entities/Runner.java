package com.uptc.frmw.Entities;

import java.sql.Date;

public class Runner {

    private Long idRunner;
    private String nameRunner;
    private String countryBirth;
    private Date dateBirth;

    public Runner() {
    }

    public Runner(Long idRunner, String nameRunner, String countryBirth, Date dateBirth) {
        this.idRunner = idRunner;
        this.nameRunner = nameRunner;
        this.countryBirth = countryBirth;
        this.dateBirth = dateBirth;
    }

    public Long getIdRunner() {
        return idRunner;
    }

    public void setIdRunner(Long idRunner) {
        this.idRunner = idRunner;
    }

    public String getNameRunner() {
        return nameRunner;
    }

    public void setNameRunner(String nameRunner) {
        this.nameRunner = nameRunner;
    }

    public String getCountryBirth() {
        return countryBirth;
    }

    public void setCountryBirth(String countryBirth) {
        this.countryBirth = countryBirth;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
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

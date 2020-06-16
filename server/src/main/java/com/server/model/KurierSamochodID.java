package com.server.model;

import java.io.Serializable;

public class KurierSamochodID implements Serializable {

    Long samochod;
    Long kurier;

    public Long getSamochod() {
        return samochod;
    }

    public void setSamochod(Long samochod) {
        this.samochod = samochod;
    }

    public Long getKurier() {
        return kurier;
    }

    public void setKurier(Long kurier) {
        this.kurier = kurier;
    }
}

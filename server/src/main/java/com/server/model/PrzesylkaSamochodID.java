package com.server.model;

import java.io.Serializable;

public class PrzesylkaSamochodID implements Serializable {

    Long samochod;
    Long przesylka;

    public Long getSamochod() {
        return samochod;
    }

    public void setSamochod(Long samochod) {
        this.samochod = samochod;
    }

    public Long getPrzesylka() {
        return przesylka;
    }

    public void setPrzesylka(Long przesylka) {
        this.przesylka = przesylka;
    }
}

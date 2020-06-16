package com.server.model;

import java.io.Serializable;

public class PrzesylkaSortowniaID implements Serializable {

    Long przesylka;
    Long sortownia;

    public Long getPrzesylka() {
        return przesylka;
    }

    public void setPrzesylka(Long przesylka) {
        this.przesylka = przesylka;
    }

    public Long getSortownia() {
        return sortownia;
    }

    public void setSortownia(Long sortownia) {
        this.sortownia = sortownia;
    }
}

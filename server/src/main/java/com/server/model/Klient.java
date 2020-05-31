package com.server.model;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "klient_id")
public class Klient extends User{
/*
    @Id
    @Column(name = "id")
    private Long id;
    @OneToOne(mappedBy = "klient")
    private User user;*/

    @OneToMany(mappedBy = "nadawca")
    private List<Przesylka> przesylki;

    private String imieinazwisko;
    private String kodpocztowy;
    private String miasto;
    private String ulica;
    private String numerdomu;
    private String nrlokalu;

    public List<Przesylka> getPrzesylki() {
        return przesylki;
    }

    public void setPrzesylki(List<Przesylka> przesylki) {
        this.przesylki = przesylki;
    }

    public String getImieinazwisko() {
        return imieinazwisko;
    }

    public void setImieinazwisko(String imieinazwisko) {
        this.imieinazwisko = imieinazwisko;
    }

    public String getKodpocztowy() {
        return kodpocztowy;
    }

    public void setKodpocztowy(String kodpocztowy) {
        this.kodpocztowy = kodpocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumerdomu() {
        return numerdomu;
    }

    public void setNumerdomu(String numerdomu) {
        this.numerdomu = numerdomu;
    }

    public String getNrlokalu() {
        return nrlokalu;
    }

    public void setNrlokalu(String nrlokalu) {
        this.nrlokalu = nrlokalu;
    }
}

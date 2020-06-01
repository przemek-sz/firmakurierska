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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="adres")
    private Adres adres;

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

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}

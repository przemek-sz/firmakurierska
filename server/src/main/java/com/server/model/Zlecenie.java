package com.server.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Zlecenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name="przesylka_id")
    private Przesylka przesylka;
    private String status;
    private String typ;
    private Date dataUtworzenia;
    private Date dataZrealizowania;
    @ManyToOne
    @JoinColumn(name = "kurier")
    private Kurier kurier;
    @OneToOne
    @JoinColumn(name = "adresodbioru")
    private Adres adresodbioru;
    @OneToOne
    @JoinColumn(name = "adresdostarczenia")
    private Adres adresdostarczenia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Przesylka getPrzesylka() {
        return przesylka;
    }

    public void setPrzesylka(Przesylka przesylka) {
        this.przesylka = przesylka;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public Date getDataZrealizowania() {
        return dataZrealizowania;
    }

    public void setDataZrealizowania(Date dataZrealizowania) {
        this.dataZrealizowania = dataZrealizowania;
    }

    public Kurier getKurier() {
        return kurier;
    }

    public void setKurier(Kurier kurier) {
        this.kurier = kurier;
    }

    public Adres getAdresodbioru() {
        return adresodbioru;
    }

    public void setAdresodbioru(Adres adresodbioru) {
        this.adresodbioru = adresodbioru;
    }

    public Adres getAdresdostarczenia() {
        return adresdostarczenia;
    }

    public void setAdresdostarczenia(Adres adresdostarczenia) {
        this.adresdostarczenia = adresdostarczenia;
    }
}

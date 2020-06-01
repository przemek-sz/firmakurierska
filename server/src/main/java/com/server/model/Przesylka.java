package com.server.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Przesylka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="nadawca")
    private Klient nadawca;
    private String imieinazwisko;
    private String tel;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="adres")
    private Adres adres;
    private String typ;
    private String rozmiar;
    private String status;
    private Date datanadania;

    private static float koszpodstawowy=5;
    private static float kosztzwyklej=5;
    private static float kosztpobraniowej=10;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Klient getNadawca() {
        return nadawca;
    }

    public void setNadawca(Klient nadawca) {
        this.nadawca = nadawca;
    }

    public String getImieinazwisko() {
        return imieinazwisko;
    }

    public void setImieinazwisko(String imieinazwisko) {
        this.imieinazwisko = imieinazwisko;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(String rozmiar) {
        this.rozmiar = rozmiar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDatanadania() {
        return datanadania;
    }

    public void setDatanadania(Date datanadania) {
        this.datanadania = datanadania;
    }

    public static float getKoszpodstawowy() {
        return koszpodstawowy;
    }

    public static void setKoszpodstawowy(float koszpodstawowy) {
        Przesylka.koszpodstawowy = koszpodstawowy;
    }

    public static float getKosztzwyklej() {
        return kosztzwyklej;
    }

    public static void setKosztzwyklej(float kosztzwyklej) {
        Przesylka.kosztzwyklej = kosztzwyklej;
    }

    public static float getKosztpobraniowej() {
        return kosztpobraniowej;
    }

    public static void setKosztpobraniowej(float kosztpobraniowej) {
        Przesylka.kosztpobraniowej = kosztpobraniowej;
    }
}

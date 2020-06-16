package com.server.dto;

import java.time.LocalDate;
import java.util.Date;

public class AllPrzesylkaDto {

    private Long id;
    private String imie;
    private String nazwisko;
    private String tel;
    private String email;
    private String kodpocztowy;
    private String miejscowosc;
    private String ulica;
    private String nrdomu;
    private String nrlokalu;
    private String typ;
    private String rozmiar;
    private String status;
    private float koszt;
    private float pobranie;
    private LocalDate datanadania;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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

    public String getKodpocztowy() {
        return kodpocztowy;
    }

    public void setKodpocztowy(String kodpocztowy) {
        this.kodpocztowy = kodpocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrdomu() {
        return nrdomu;
    }

    public void setNrdomu(String nrdomu) {
        this.nrdomu = nrdomu;
    }

    public String getNrlokalu() {
        return nrlokalu;
    }

    public void setNrlokalu(String nrlokalu) {
        this.nrlokalu = nrlokalu;
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

    public LocalDate getDatanadania() {
        return datanadania;
    }

    public void setDatanadania(LocalDate datanadania) {
        this.datanadania = datanadania;
    }

    public float getKoszt() {
        return koszt;
    }

    public void setKoszt(float koszt) {
        this.koszt = koszt;
    }

    public float getPobranie() {
        return pobranie;
    }

    public void setPobranie(float pobranie) {
        this.pobranie = pobranie;
    }
}

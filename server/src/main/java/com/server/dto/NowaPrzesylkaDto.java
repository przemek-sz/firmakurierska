package com.server.dto;

import com.server.model.Status;
import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Validated
public class NowaPrzesylkaDto {

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
    private Long typ;
    private Long rozmiar;
    private String waga;
    private String pobranie;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTyp() {
        return typ;
    }

    public void setTyp(Long typ) {
        this.typ = typ;
    }

    public Long getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(Long rozmiar) {
        this.rozmiar = rozmiar;
    }

    public String getWaga() {
        return waga;
    }

    public void setWaga(String waga) {
        this.waga = waga;
    }

    public String getPobranie() {
        return pobranie;
    }

    public void setPobranie(String pobranie) {
        this.pobranie = pobranie;
    }


    @Override
    public String toString() {
        return "NowaPrzesylkaDto{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", kodpocztowy='" + kodpocztowy + '\'' +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nrdomu='" + nrdomu + '\'' +
                ", nrlokalu='" + nrlokalu + '\'' +
                ", typ=" + typ +
                ", rozmiar='" + rozmiar + '\'' +
                ", waga='" + waga + '\'' +
                ", pobranie='" + pobranie + '\'' +
                '}';
    }
}

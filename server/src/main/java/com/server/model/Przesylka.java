package com.server.model;

import com.server.model.users.Klient;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;


import java.time.LocalDate;
import java.util.Date;

@Entity
@Validated
public class Przesylka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="nadawca_id")
    @NotNull
    private Klient nadawca;
    @NotNull
    @Size(min = 1)
    private String imie;
    @NotNull
    @Size(min = 1)
    private String nazwisko;
    @NotNull
    @Size(min = 9)
    private String tel;
    @NotNull
    @Email
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="adres_id")
    @NotNull
    private Adres adres;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "typ_id")
    @NotNull
    private Typ typ;
    @NotNull
    @Size(min = 9)
    private String rozmiar;
    @NotNull
    @Min(1)
    private int waga;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;
    @NotNull
    private LocalDate datanadania;
    @NotNull
    @Min(1)
    private float koszt;
    private float pobranie;
    @NotNull
    @Min(1)
    private int rozmiarSuma;

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

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }

    public String getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(String rozmiar) {
        this.rozmiar = rozmiar;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public int getRozmiarSuma() {
        return rozmiarSuma;
    }

    public void setRozmiarSuma(int rozmiarSuma) {
        this.rozmiarSuma = rozmiarSuma;
    }

    @Override
    public String toString() {
        return "Przesylka{" +
                "id=" + id +
                ", nadawca=" + nadawca +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", adres=" + adres +
                ", typ=" + typ +
                ", rozmiar='" + rozmiar + '\'' +
                ", waga=" + waga +
                ", status=" + status +
                ", datanadania=" + datanadania +
                ", koszt=" + koszt +
                ", pobranie=" + pobranie +
                ", rozmiarSuma=" + rozmiarSuma +
                '}';
    }
}

package com.server.model.users;

import com.server.model.Sortownia;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class PracownikSortowni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nazwaDzialu;

    @OneToOne
    @JoinColumn(name="pracownik_id")
    Pracownik pracownik;

    @ManyToOne
    private Sortownia sortownia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwaDzialu() {
        return nazwaDzialu;
    }

    public void setNazwaDzialu(String nazwaDzialu) {
        this.nazwaDzialu = nazwaDzialu;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Sortownia getSortownia() {
        return sortownia;
    }

    public void setSortownia(Sortownia sortownia) {
        this.sortownia = sortownia;
    }
}

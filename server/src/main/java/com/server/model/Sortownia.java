package com.server.model;

import com.server.model.users.PracownikSortowni;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sortownia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="adres_id")
    @NotNull
    private Adres adres;

    @OneToMany(mappedBy = "sortownia")
    List<PracownikSortowni> pracownicy = new ArrayList<>();

    @OneToMany(mappedBy = "sortownia")
    List<PrzesylkaSortownia> przesylki = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}

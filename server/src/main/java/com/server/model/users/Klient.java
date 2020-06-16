package com.server.model.users;

import com.server.model.Adres;
import com.server.model.Przesylka;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Klient{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nrKonta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    @NotNull
    private User user;

    @OneToMany(mappedBy = "nadawca")
    private List<Przesylka> przesylki;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="adres_id")
    @NotNull
    private Adres adres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNrKonta() {
        return nrKonta;
    }

    public void setNrKonta(String nrKonta) {
        this.nrKonta = nrKonta;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Przesylka> getPrzesylki() {
        return przesylki;
    }

    public void setPrzesylki(List<Przesylka> przesylki) {
        this.przesylki = przesylki;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}

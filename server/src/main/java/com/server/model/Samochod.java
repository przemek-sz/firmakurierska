package com.server.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Samochod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typ;
    private String marka;
    private String nr_rejestracyjny;
    private int ladownosc;
    private int pojemnosc;

    @OneToMany(mappedBy = "samochod")
    private List<PrzesylkaSamochod> przesylki;

    @OneToMany(mappedBy = "samochod")
    List<KurierSamochod> kurierzy = new ArrayList<>();

}

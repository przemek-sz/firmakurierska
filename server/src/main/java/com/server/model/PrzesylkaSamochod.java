package com.server.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(PrzesylkaSamochodID.class)
public class PrzesylkaSamochod {

    @Id
    @ManyToOne
    @JoinColumn(name = "samochod_id", referencedColumnName = "id")
    private Samochod samochod;

    @Id
    @ManyToOne
    @JoinColumn(name = "przesylka_id", referencedColumnName = "id")
    private Przesylka przesylka;

    private Date data_przewozu;
}

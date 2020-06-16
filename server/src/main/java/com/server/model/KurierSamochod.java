package com.server.model;

import com.server.model.users.Kurier;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(KurierSamochodID.class)
public class KurierSamochod {

    @Id
    @ManyToOne
    @JoinColumn(name = "samochod_id", referencedColumnName = "id")
    private Samochod samochod;

    @Id
    @ManyToOne
    @JoinColumn(name = "kurier_id", referencedColumnName = "id")
    private Kurier kurier;

    private Date data_przydzialu;
}

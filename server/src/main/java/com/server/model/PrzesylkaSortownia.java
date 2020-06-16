package com.server.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@IdClass(PrzesylkaSortowniaID.class)
public class PrzesylkaSortownia {

    @Id
    @ManyToOne
    @JoinColumn(name = "przesylka_id", referencedColumnName = "id")
    Przesylka przesylka;

    @Id
    @ManyToOne
    @JoinColumn(name = "sortownia_id", referencedColumnName = "id")
    Sortownia sortownia;

    private Date data_dostarczenia;
    private Date data_wydania;
}

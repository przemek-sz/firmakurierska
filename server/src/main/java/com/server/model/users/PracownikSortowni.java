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
    @NotNull
    Pracownik pracownik;

    @ManyToOne
    private Sortownia sortownia;
}

package com.server.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "kurier_id")
public class Kurier extends User{

    private String imieinazwisko;
    private float pensja;
    private float wyplata;
    @OneToMany(mappedBy = "kurier")
    private List<Zlecenie> zleceniaKuriera;

}

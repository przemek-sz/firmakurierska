package com.server.model.users;

import com.server.model.KurierSamochod;
import com.server.model.PrzesylkaSortownia;
import com.server.model.Zlecenie;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Kurier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name="pracownik_id")
    @NotNull
    Pracownik pracownik;

    private int iloscZlecenWMiesiacu;

    @OneToMany(mappedBy = "kurier")
    private List<Zlecenie> zleceniaKuriera;

    @OneToMany(mappedBy = "kurier")
    List<KurierSamochod> samochody = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public int getIloscZlecenWMiesiacu() {
        return iloscZlecenWMiesiacu;
    }

    public void setIloscZlecenWMiesiacu(int iloscZlecenWMiesiacu) {
        this.iloscZlecenWMiesiacu = iloscZlecenWMiesiacu;
    }

    public List<Zlecenie> getZleceniaKuriera() {
        return zleceniaKuriera;
    }

    public void setZleceniaKuriera(List<Zlecenie> zleceniaKuriera) {
        this.zleceniaKuriera = zleceniaKuriera;
    }
}

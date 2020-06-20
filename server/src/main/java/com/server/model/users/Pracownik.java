package com.server.model.users;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float pensja;
    private float premia;
    private LocalDate dataZatrudnienia;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="user_id")
    @NotNull
    private User user;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="kurier_id")
    private Kurier kurier;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="pracownik_sortowni_id")
    private PracownikSortowni pracownikSortowni;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPensja() {
        return pensja;
    }

    public void setPensja(float pensja) {
        this.pensja = pensja;
    }

    public float getPremia() {
        return premia;
    }

    public void setPremia(float premia) {
        this.premia = premia;
    }

    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Kurier getKurier() {
        return kurier;
    }

    public void setKurier(Kurier kurier) {
        this.kurier = kurier;
    }

    public PracownikSortowni getPracownikSortowni() {
        return pracownikSortowni;
    }

    public void setPracownikSortowni(PracownikSortowni pracownikSortowni) {
        this.pracownikSortowni = pracownikSortowni;
    }
}

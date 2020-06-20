package com.server.service;

import com.server.model.Adres;

public interface AdresService {

    public void addAdres(Adres user);
    public void updateAdres(Adres klient);
    public void removeAdres(Adres klient);
    public Adres getById(Long id);
    public Adres getByAllColumns(String kod, String miejscowosc, String ulica, String nrdomu, String nrlokalu);
}

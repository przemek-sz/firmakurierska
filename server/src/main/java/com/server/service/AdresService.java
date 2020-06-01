package com.server.service;

import com.server.dto.AllKlientDto;
import com.server.dto.KlientRegistrationDto;
import com.server.model.Adres;
import com.server.model.Klient;

import java.util.List;

public interface AdresService {

    public void addAdres(Adres user);
    public void updateAdres(Adres klient);
    public void removeAdres(Adres klient);
    public Adres getById(Long id);
}

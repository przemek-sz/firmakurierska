package com.server.service;

import com.server.dto.AllKlientDto;
import com.server.dto.KlientRegistrationDto;
import com.server.model.users.Klient;

import java.util.List;


public interface KlientService {

    public void addKlient(KlientRegistrationDto user);
    public void updateKlient(Klient klient);
    public void removeKlient(Klient klient);
    public List<AllKlientDto> getAllKlients();
    public Klient getByUsername(String username);
    public Klient getById(Long id);
}

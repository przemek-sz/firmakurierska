package com.server.service;

import com.server.dto.AllUserDto;
import com.server.dto.UserRegistrationDto;
import com.server.model.Przesylka;
import com.server.model.User;
import com.server.model.Zlecenie;

import java.util.List;

public interface ZlecenieService {

    public void addZlecenie(Zlecenie zlecenie);
    public Zlecenie createZlecenieOdbioruOdKlienta(Przesylka przesylka);
    public void updateZlecenie(Zlecenie zlecenie);
    //public List<AllUserDto> getAllUsers();
    public User getByid(Long id);
}

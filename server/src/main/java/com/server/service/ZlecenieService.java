package com.server.service;

import com.server.model.Przesylka;
import com.server.model.users.User;
import com.server.model.Zlecenie;

public interface ZlecenieService {

    public void addZlecenie(Zlecenie zlecenie);
    public Zlecenie createZlecenieOdbioruOdKlienta(Przesylka przesylka);
    public void updateZlecenie(Zlecenie zlecenie);
    //public List<AllUserDto> getAllUsers();
    public User getByid(Long id);
}

package com.server.service;

import com.server.dto.AllKlientDto;
import com.server.dto.AllUserDto;
import com.server.dto.KlientRegistrationDto;
import com.server.dto.UserRegistrationDto;
import com.server.model.Klient;
import com.server.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface KlientService {

    public void addUser(KlientRegistrationDto user);
    public void updateUser(Klient klient);
    public void removeUser(Klient klient);
    public List<AllKlientDto> getAllUsers();
    public Klient getByusername(String username);
    public Klient getByid(Long id);
}

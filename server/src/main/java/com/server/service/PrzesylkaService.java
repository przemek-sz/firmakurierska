package com.server.service;

import com.server.dto.AllPrzesylkaDto;
import com.server.dto.AllUserDto;
import com.server.dto.NowaPrzesylkaDto;
import com.server.dto.UserRegistrationDto;
import com.server.model.Przesylka;
import com.server.model.User;

import java.util.List;

public interface PrzesylkaService {

    public void nowaPrzesylka(NowaPrzesylkaDto przesylkaDto,String username);
    public void updatePrzesylka(Przesylka przesylka);
    public void removeUser(Przesylka przesylka);
    public List<AllPrzesylkaDto> getAllPrzesylkaDto(String username);
    public AllPrzesylkaDto getByid(Long id);
}

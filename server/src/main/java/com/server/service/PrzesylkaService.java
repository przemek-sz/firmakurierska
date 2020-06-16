package com.server.service;

import com.server.dto.AllPrzesylkaDto;
import com.server.dto.NowaPrzesylkaDto;
import com.server.model.Przesylka;

import java.util.List;

public interface PrzesylkaService {

    public AllPrzesylkaDto nowaPrzesylka(NowaPrzesylkaDto przesylkaDto,String username);
    public void updatePrzesylka(Przesylka przesylka);
    public void removeUser(Przesylka przesylka);
    public List<AllPrzesylkaDto> getAllPrzesylkaDto(String username);
   // public AllPrzesylkaDto getDtoByid(Long id);
    public Przesylka getByid(Long id);
    public AllPrzesylkaDto editPrzesylka(NowaPrzesylkaDto nowaPrzesylkaDto,String username);
    public void setAnulowana(Long id);
    float obliczKoszt(float typ, int rozmiar, int waga);
}

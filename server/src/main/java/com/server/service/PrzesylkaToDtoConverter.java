package com.server.service;

import com.server.dto.AllKlientDto;
import com.server.dto.AllPrzesylkaDto;
import com.server.model.Klient;
import com.server.model.Przesylka;
import org.springframework.stereotype.Service;

@Service
public class PrzesylkaToDtoConverter implements BaseConverter<Przesylka, AllPrzesylkaDto>{
    @Override
    public AllPrzesylkaDto convert(Przesylka from)
    {
        AllPrzesylkaDto przesylkaDto = new AllPrzesylkaDto();
        przesylkaDto.setId(from.getId());
        przesylkaDto.setImieinazwisko(from.getImieinazwisko());
        przesylkaDto.setTel(from.getTel());
        przesylkaDto.setEmail(from.getEmail());
        przesylkaDto.setKodpocztowy(from.getKodpocztowy());
        przesylkaDto.setMiejscowosc(from.getMiejscowosc());
        przesylkaDto.setUlica(from.getUlica());
        przesylkaDto.setNrdomu(from.getNrdomu());
        przesylkaDto.setNrlokalu(from.getNrlokalu());
        przesylkaDto.setTyp(from.getTyp());
        przesylkaDto.setRozmiar(from.getRozmiar());
        return przesylkaDto;
    }
}


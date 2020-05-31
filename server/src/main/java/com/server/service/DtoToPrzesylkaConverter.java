package com.server.service;

import com.server.dto.NowaPrzesylkaDto;
import com.server.model.Przesylka;
import org.springframework.stereotype.Service;

@Service
public class DtoToPrzesylkaConverter implements BaseConverter<NowaPrzesylkaDto,Przesylka>{

    @Override
    public Przesylka convert(NowaPrzesylkaDto from) {

        Przesylka przesylka = new Przesylka();
        przesylka.setImieinazwisko(from.getImieinazwisko());
        przesylka.setTel(from.getTel());
        przesylka.setEmail(from.getEmail());
        przesylka.setKodpocztowy(from.getKodpocztowy());
        przesylka.setMiejscowosc(from.getMiejscowosc());
        przesylka.setUlica(from.getUlica());
        przesylka.setNrdomu(from.getNrdomu());
        przesylka.setNrlokalu(from.getNrlokalu());
        przesylka.setTyp(from.getTyp());
        przesylka.setRozmiar(from.getRozmiar());


        return przesylka;
    }
}

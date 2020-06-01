package com.server.service.dtoconverters;

import com.server.dto.NowaPrzesylkaDto;
import com.server.model.Adres;
import com.server.model.Przesylka;
import org.springframework.stereotype.Service;

@Service
public class DtoToPrzesylkaConverter implements BaseConverter<NowaPrzesylkaDto,Przesylka>{

    @Override
    public Przesylka convert(NowaPrzesylkaDto from) {

        Przesylka przesylka = new Przesylka();
        Adres adres = new Adres();
        przesylka.setImieinazwisko(from.getImieinazwisko());
        przesylka.setTel(from.getTel());
        przesylka.setEmail(from.getEmail());

        przesylka.setAdres(adres);
        adres.setKodpocztowy(from.getKodpocztowy());
        adres.setMiasto(from.getMiejscowosc());
        adres.setUlica(from.getUlica());
        adres.setNumerdomu(from.getNrdomu());
        adres.setNrlokalu(from.getNrlokalu());

        przesylka.setTyp(from.getTyp());
        przesylka.setRozmiar(from.getRozmiar());
        przesylka.setStatus("do_obioru");


        return przesylka;
    }
}

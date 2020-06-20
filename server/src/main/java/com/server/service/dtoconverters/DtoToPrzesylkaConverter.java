package com.server.service.dtoconverters;

import com.server.dto.NowaPrzesylkaDto;
import com.server.model.Adres;
import com.server.model.Przesylka;
import com.server.model.Status;
import org.springframework.stereotype.Service;

@Service
public class DtoToPrzesylkaConverter implements BaseConverter<NowaPrzesylkaDto,Przesylka>{

    @Override
    public Przesylka convert(NowaPrzesylkaDto from) {

        Przesylka przesylka = new Przesylka();
        Adres adres = new Adres();
        if(from.getId()!=null)
            przesylka.setId(from.getId());
        przesylka.setImie(from.getImie());
        przesylka.setNazwisko(from.getNazwisko());
        przesylka.setTel(from.getTel());
        przesylka.setEmail(from.getEmail());

        przesylka.setAdres(adres);
        adres.setKodpocztowy(from.getKodpocztowy());
        adres.setMiejscowosc(from.getMiejscowosc());
        adres.setUlica(from.getUlica());
        adres.setNumerdomu(from.getNrdomu());
        adres.setNrlokalu(from.getNrlokalu());

        przesylka.setWaga(Integer.parseInt(from.getWaga()));

        return przesylka;
    }
}

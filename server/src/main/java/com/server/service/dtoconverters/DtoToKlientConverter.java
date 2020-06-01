package com.server.service.dtoconverters;

import com.server.dto.KlientRegistrationDto;
import com.server.model.Adres;
import com.server.model.Klient;
import org.springframework.stereotype.Service;

@Service
public class DtoToKlientConverter implements BaseConverter<KlientRegistrationDto, Klient>{
    @Override
    public Klient convert(KlientRegistrationDto from) {

        Klient klient = new Klient();
        Adres adres = new Adres();

        klient.setUsername(from.getUsername());
        klient.setEmail(from.getEmail());
        klient.setPassword(from.getPassword());
        klient.setImieinazwisko(from.getImieinazwisko());
        klient.setAdres(adres);

        adres.setKodpocztowy(from.getKodpocztowy());
        adres.setMiasto(from.getMiasto());
        adres.setUlica(from.getUlica());
        adres.setNumerdomu(from.getNumerdomu());
        adres.setNrlokalu(from.getNrlokalu());

        return klient;
    }
}

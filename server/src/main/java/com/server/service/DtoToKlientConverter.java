package com.server.service;

import com.server.dto.KlientRegistrationDto;
import com.server.model.Klient;
import org.springframework.stereotype.Service;

@Service
public class DtoToKlientConverter implements BaseConverter<KlientRegistrationDto, Klient>{
    @Override
    public Klient convert(KlientRegistrationDto from) {

        Klient klient = new Klient();
        klient.setUsername(from.getUsername());
        klient.setEmail(from.getEmail());
        klient.setPassword(from.getPassword());
        klient.setImieinazwisko(from.getImieinazwisko());
        klient.setKodpocztowy(from.getKodpocztowy());
        klient.setMiasto(from.getMiasto());
        klient.setUlica(from.getUlica());
        klient.setNumerdomu(from.getNumerdomu());
        klient.setNrlokalu(from.getNrlokalu());

        return klient;
    }
}

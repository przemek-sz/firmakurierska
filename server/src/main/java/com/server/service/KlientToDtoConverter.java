package com.server.service;

import com.server.dto.AllKlientDto;
import com.server.dto.AllUserDto;
import com.server.model.Klient;
import com.server.model.User;
import org.springframework.stereotype.Service;

@Service
public class KlientToDtoConverter implements BaseConverter<Klient, AllKlientDto>{
    @Override
    public AllKlientDto convert(Klient from) {

        AllKlientDto klientDto= new AllKlientDto();
        klientDto.setId(from.getId());
        klientDto.setUsername(from.getUsername());
        klientDto.setEmail(from.getEmail());
        klientDto.setImieinazwisko(from.getImieinazwisko());
        klientDto.setKodpocztowy(from.getKodpocztowy());
        klientDto.setMiasto(from.getMiasto());
        klientDto.setUlica(from.getUlica());
        klientDto.setNumerdomu(from.getNumerdomu());
        klientDto.setNrlokalu(from.getNrlokalu());

        return klientDto;
    }
}

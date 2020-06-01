package com.server.service.dtoconverters;

import com.server.dto.AllKlientDto;
import com.server.model.Klient;
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
        klientDto.setKodpocztowy(from.getAdres().getKodpocztowy());
        klientDto.setMiasto(from.getAdres().getMiasto());
        klientDto.setUlica(from.getAdres().getUlica());
        klientDto.setNumerdomu(from.getAdres().getNumerdomu());
        klientDto.setNrlokalu(from.getAdres().getNrlokalu());

        return klientDto;
    }
}

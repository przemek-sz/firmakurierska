package com.server.service.dtoconverters;

import com.server.dto.AllKlientDto;
import com.server.model.users.Klient;
import org.springframework.stereotype.Service;

@Service
public class KlientToDtoConverter implements BaseConverter<Klient, AllKlientDto>{
    @Override
    public AllKlientDto convert(Klient from) {

        AllKlientDto klientDto= new AllKlientDto();
        klientDto.setId(from.getId());
        klientDto.setUsername(from.getUser().getUsername());
        klientDto.setEmail(from.getUser().getEmail());
        klientDto.setImieinazwisko(from.getUser().getImie());
        klientDto.setImieinazwisko(from.getUser().getNazwisko());
        klientDto.setKodpocztowy(from.getAdres().getKodpocztowy());
        klientDto.setMiasto(from.getAdres().getMiejscowosc());
        klientDto.setUlica(from.getAdres().getUlica());
        klientDto.setNumerdomu(from.getAdres().getNumerdomu());
        klientDto.setNrlokalu(from.getAdres().getNrlokalu());

        return klientDto;
    }
}

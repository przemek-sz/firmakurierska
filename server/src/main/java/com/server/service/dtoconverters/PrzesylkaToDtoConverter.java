package com.server.service.dtoconverters;

import com.server.dto.AllPrzesylkaDto;
import com.server.model.Przesylka;
import org.springframework.stereotype.Service;

@Service
public class PrzesylkaToDtoConverter implements BaseConverter<Przesylka, AllPrzesylkaDto>{
    @Override
    public AllPrzesylkaDto convert(Przesylka from)
    {
        AllPrzesylkaDto przesylkaDto = new AllPrzesylkaDto();
        przesylkaDto.setId(from.getId());
        przesylkaDto.setImie(from.getImie());
        przesylkaDto.setNazwisko(from.getNazwisko());
        przesylkaDto.setTel(from.getTel());
        przesylkaDto.setEmail(from.getEmail());
        przesylkaDto.setKodpocztowy(from.getAdres().getKodpocztowy());
        przesylkaDto.setMiejscowosc(from.getAdres().getMiejscowosc());
        przesylkaDto.setUlica(from.getAdres().getUlica());
        przesylkaDto.setNrdomu(from.getAdres().getNumerdomu());
        przesylkaDto.setNrlokalu(from.getAdres().getNrlokalu());
        przesylkaDto.setTyp(from.getTyp().getNazwa());
        przesylkaDto.setRozmiar(from.getRozmiar());
        przesylkaDto.setStatus(from.getStatus().name());
        przesylkaDto.setDatanadania(from.getDatanadania());
        przesylkaDto.setKoszt(from.getKoszt());
        przesylkaDto.setPobranie(from.getPobranie());
        return przesylkaDto;
    }
}


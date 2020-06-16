package com.server.service.impl;

import com.server.dto.AllPrzesylkaDto;
import com.server.dto.NowaPrzesylkaDto;
import com.server.model.Przesylka;
import com.server.model.Status;
import com.server.model.Typ;
import com.server.model.Zlecenie;
import com.server.repository.PrzesylkaRepository;
import com.server.service.KlientService;
import com.server.service.PrzesylkaService;
import com.server.service.TypService;
import com.server.service.ZlecenieService;
import com.server.service.dtoconverters.BaseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PrzesylkaServiceImpl implements PrzesylkaService {

    private PrzesylkaRepository przesylkaRepository;
    private KlientService klientService;
    private TypService typService;
    private ZlecenieService zlecenieService;
    private BaseConverter<Przesylka, AllPrzesylkaDto> baseConverter;
    private BaseConverter<NowaPrzesylkaDto, Przesylka> przesylkaBaseConverter;

    @Autowired
    PrzesylkaServiceImpl(PrzesylkaRepository przesylkaRepository, BaseConverter<NowaPrzesylkaDto,Przesylka> przesylkaBaseConverter, BaseConverter<Przesylka, AllPrzesylkaDto> baseConverter, KlientService klientService, ZlecenieService zlecenieService, TypService typService){
        this.przesylkaRepository=przesylkaRepository;
        this.przesylkaBaseConverter=przesylkaBaseConverter;
        this.baseConverter=baseConverter;
        this.klientService=klientService;
        this.zlecenieService=zlecenieService;
        this.typService=typService;
    }

    @Override
    public AllPrzesylkaDto nowaPrzesylka(NowaPrzesylkaDto przesylkaDto, String username) {

        Typ typ = typService.getById(przesylkaDto.getTyp());

        Przesylka przesylka=przesylkaBaseConverter.convert(przesylkaDto);
        przesylka.setTyp(typ);
        przesylka.setStatus(Status.DOODBIORU);
        przesylka.setDatanadania(LocalDate.now());
        przesylka.setNadawca(klientService.getByUsername(username));


        przesylka.setKoszt(obliczKoszt(typ.getKoszt(),przesylka.getRozmiarSuma(),przesylka.getWaga()));
        if(typ.getNazwa().equals("Pobraniowa")) {
            przesylka.setPobranie(przesylka.getKoszt()+Float.parseFloat(przesylkaDto.getPobranie().replace(",",".")));
        }
        przesylkaRepository.save(przesylka);

        Zlecenie zlecenie = zlecenieService.createZlecenieOdbioruOdKlienta(przesylka);
        zlecenieService.addZlecenie(zlecenie);

        return baseConverter.convert(przesylka);
    }

    @Override
    public void updatePrzesylka(Przesylka przesylka) {
        przesylkaRepository.save(przesylka);
    }

    @Override
    public void removeUser(Przesylka przesylka) {

    }

    @Override
    public List<AllPrzesylkaDto> getAllPrzesylkaDto(String username) {

        return baseConverter.convertAll(
                przesylkaRepository.getByNadawca(
                        klientService.getByUsername(username)));
    }

    @Override
    public Przesylka getByid(Long id) {
        return przesylkaRepository.getOne(id);
    }

    @Override
    public AllPrzesylkaDto editPrzesylka(NowaPrzesylkaDto przesylkaDto,String username) {

        Przesylka oldPrzesylka = przesylkaRepository.getOne(przesylkaDto.getId());
        Typ typ = typService.getById(przesylkaDto.getTyp());
        Przesylka newPrzesylka = przesylkaBaseConverter.convert(przesylkaDto);

        newPrzesylka.setNadawca(klientService.getByUsername(username));
        newPrzesylka.setTyp(typ);
        newPrzesylka.setKoszt(obliczKoszt(typ.getKoszt(),newPrzesylka.getRozmiarSuma(),newPrzesylka.getWaga()));
        if(typ.getNazwa().equals("Pobraniowa")) {
            newPrzesylka.setPobranie(newPrzesylka.getKoszt()+Float.parseFloat(przesylkaDto.getPobranie().replace(",",".")));
        }
        newPrzesylka.setStatus(oldPrzesylka.getStatus());
        System.out.println(oldPrzesylka.getDatanadania());
        newPrzesylka.setDatanadania(oldPrzesylka.getDatanadania());
        System.out.println(newPrzesylka.getDatanadania());

        System.out.println(newPrzesylka.toString());

        this.updatePrzesylka(newPrzesylka);

        return baseConverter.convert(newPrzesylka);
    }

    @Override
    public void setAnulowana(Long id) {
        Przesylka przesylka = this.getByid(id);
        przesylka.setStatus(Status.ANULOWANA);
        this.updatePrzesylka(przesylka);
    }

    @Override
    public float obliczKoszt(float typ,int rozmiar,int waga) {
        return typ+rozmiar/10+waga/10;
    }
}

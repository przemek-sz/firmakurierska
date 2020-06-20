package com.server.service.impl;

import com.server.dto.AllPrzesylkaDto;
import com.server.dto.NowaPrzesylkaDto;
import com.server.model.*;
import com.server.repository.PrzesylkaRepository;
import com.server.repository.RozmiarRepository;
import com.server.service.*;
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
    private RozmiarRepository rozmiarRepository;
    private ZlecenieService zlecenieService;
    private BaseConverter<Przesylka, AllPrzesylkaDto> baseConverter;
    private BaseConverter<NowaPrzesylkaDto, Przesylka> przesylkaBaseConverter;
    private AdresService adresService;

    @Autowired
    PrzesylkaServiceImpl(PrzesylkaRepository przesylkaRepository, BaseConverter<NowaPrzesylkaDto,Przesylka> przesylkaBaseConverter, BaseConverter<Przesylka, AllPrzesylkaDto> baseConverter, KlientService klientService, ZlecenieService zlecenieService, TypService typService, RozmiarRepository rozmiarRepository, AdresService adresService){
        this.przesylkaRepository=przesylkaRepository;
        this.przesylkaBaseConverter=przesylkaBaseConverter;
        this.baseConverter=baseConverter;
        this.klientService=klientService;
        this.zlecenieService=zlecenieService;
        this.typService=typService;
        this.rozmiarRepository=rozmiarRepository;
        this.adresService=adresService;
    }

    @Override
    public AllPrzesylkaDto nowaPrzesylka(NowaPrzesylkaDto przesylkaDto, String username) {

        Typ typ = typService.getById(przesylkaDto.getTyp());

        Przesylka przesylka=przesylkaBaseConverter.convert(przesylkaDto);
        przesylka.setTyp(typ);
        przesylka.setStatus(Status.DOODBIORU);
        przesylka.setDatanadania(LocalDate.now());
        przesylka.setNadawca(klientService.getByUsername(username));

        Adres adresFromDto = przesylka.getAdres();

        Adres adresFromdDatabase = adresService.getByAllColumns(adresFromDto.getKodpocztowy(),adresFromDto.getMiejscowosc(),adresFromDto.getUlica(),adresFromDto.getNumerdomu(),adresFromDto.getNrlokalu());

        if(adresFromdDatabase!=null)
            przesylka.setAdres(adresFromdDatabase);

        przesylka.setRozmiar(rozmiarRepository.getOne(przesylkaDto.getRozmiar()));
        int r=0;

        for(String s : przesylka.getRozmiar().getRozmiar().split("x")){
            r+=Integer.parseInt(s.trim());
        }
        przesylka.setRozmiarSuma(r);


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
        Rozmiar rozmiar = rozmiarRepository.getOne(przesylkaDto.getRozmiar());
        Przesylka newPrzesylka = przesylkaBaseConverter.convert(przesylkaDto);

        Adres adresFromDto = newPrzesylka.getAdres();

        Adres adresFromdDatabase = adresService.getByAllColumns(adresFromDto.getKodpocztowy(),adresFromDto.getMiejscowosc(),adresFromDto.getUlica(),adresFromDto.getNumerdomu(),adresFromDto.getNrlokalu());

        if(adresFromdDatabase!=null)
            newPrzesylka.setAdres(adresFromdDatabase);

        newPrzesylka.setNadawca(klientService.getByUsername(username));
        newPrzesylka.setTyp(typ);
        newPrzesylka.setRozmiar(rozmiar);
        int r=0;

        for(String s : newPrzesylka.getRozmiar().getRozmiar().split("x")){
            r+=Integer.parseInt(s.trim());
        }
        newPrzesylka.setRozmiarSuma(r);
        newPrzesylka.setKoszt(obliczKoszt(typ.getKoszt(),newPrzesylka.getRozmiarSuma(),newPrzesylka.getWaga()));
        if(typ.getNazwa().equals("Pobraniowa")) {
            newPrzesylka.setPobranie(newPrzesylka.getKoszt()+Float.parseFloat(przesylkaDto.getPobranie().replace(",",".")));
        }
        newPrzesylka.setStatus(oldPrzesylka.getStatus());

        newPrzesylka.setDatanadania(oldPrzesylka.getDatanadania());




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

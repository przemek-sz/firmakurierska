package com.server.service;

import com.server.dto.AllPrzesylkaDto;
import com.server.dto.NowaPrzesylkaDto;
import com.server.model.Przesylka;
import com.server.model.Zlecenie;
import com.server.repository.PrzesylkaRepository;
import com.server.service.dtoconverters.BaseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PrzesylkaServiceImpl implements PrzesylkaService {

    private PrzesylkaRepository przesylkaRepository;
    private KlientService klientService;
    private ZlecenieService zlecenieService;
    private BaseConverter<Przesylka, AllPrzesylkaDto> baseConverter;
    private BaseConverter<NowaPrzesylkaDto, Przesylka> przesylkaBaseConverter;

    @Autowired
    PrzesylkaServiceImpl(PrzesylkaRepository przesylkaRepository, BaseConverter<NowaPrzesylkaDto,Przesylka> przesylkaBaseConverter, BaseConverter<Przesylka, AllPrzesylkaDto> baseConverter, KlientService klientService, ZlecenieService zlecenieService){
        this.przesylkaRepository=przesylkaRepository;
        this.przesylkaBaseConverter=przesylkaBaseConverter;
        this.baseConverter=baseConverter;
        this.klientService=klientService;
        this.zlecenieService=zlecenieService;
    }

    @Override
    public AllPrzesylkaDto nowaPrzesylka(NowaPrzesylkaDto przesylkaDto, String username) {

        Przesylka przesylka=przesylkaBaseConverter.convert(przesylkaDto);
        przesylka.setDatanadania(new Date());
        przesylka.setNadawca(klientService.getByusername(username));
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

//        Klient nadawca = klientService.getByusername(username);
//        List<Przesylka> przesylki = przesylkaRepository.getByNadawca(nadawca);
//
//        List<AllPrzesylkaDto> przesylkiKlienta=baseConverter.convertAll(przesylki);
//        return przesylkiKlienta;

        return baseConverter.convertAll(
                przesylkaRepository.getByNadawca(
                        klientService.getByusername(username)));
    }

    @Override
    public AllPrzesylkaDto getDtoByid(Long id) {
        return null;
    }

    @Override
    public Przesylka getByid(Long id) {
        return przesylkaRepository.getOne(id);
    }

    @Override
    public void setAnulowana(Long id) {
        Przesylka przesylka = this.getByid(id);
        przesylka.setStatus("anulowana");
        this.updatePrzesylka(przesylka);
    }
}

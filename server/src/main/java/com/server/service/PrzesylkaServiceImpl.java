package com.server.service;

import com.server.dto.AllKlientDto;
import com.server.dto.AllPrzesylkaDto;
import com.server.dto.KlientRegistrationDto;
import com.server.dto.NowaPrzesylkaDto;
import com.server.model.Klient;
import com.server.model.Przesylka;
import com.server.repository.PrzesylkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PrzesylkaServiceImpl implements PrzesylkaService {

    private PrzesylkaRepository przesylkaRepository;
    private KlientService klientService;
    private BaseConverter<Przesylka, AllPrzesylkaDto> baseConverter;
    private BaseConverter<NowaPrzesylkaDto, Przesylka> przesylkaBaseConverter;

    @Autowired
    PrzesylkaServiceImpl(PrzesylkaRepository przesylkaRepository,BaseConverter<NowaPrzesylkaDto,Przesylka> przesylkaBaseConverter, BaseConverter<Przesylka, AllPrzesylkaDto> baseConverter, KlientService klientService){
        this.przesylkaRepository=przesylkaRepository;
        this.przesylkaBaseConverter=przesylkaBaseConverter;
        this.baseConverter=baseConverter;
        this.klientService=klientService;
    }

    @Override
    public void nowaPrzesylka(NowaPrzesylkaDto przesylkaDto, String username) {

        Przesylka przesylka=przesylkaBaseConverter.convert(przesylkaDto);
        przesylka.setNadawca(klientService.getByusername(username));
        //klient.getRoles().add(userRoleRepository.getByRole(DEFAULT_ROLE));

        przesylkaRepository.save(przesylka);
    }

    @Override
    public void updatePrzesylka(Przesylka przesylka) {

    }

    @Override
    public void removeUser(Przesylka przesylka) {

    }

    @Override
    public List<AllPrzesylkaDto> getAllPrzesylkaDto(String username) {
        System.out.println("service");

        Klient nadawca = klientService.getByusername(username);
        List<Przesylka> przesylkas = przesylkaRepository.getByNadawca(nadawca);
        System.out.println(przesylkas.toString());
        List<AllPrzesylkaDto> przesylkiKlienta=baseConverter.convertAll(przesylkas);
        System.out.println(przesylkiKlienta.toString());
        return przesylkiKlienta;
    }

    @Override
    public AllPrzesylkaDto getByid(Long id) {
        return null;
    }
}

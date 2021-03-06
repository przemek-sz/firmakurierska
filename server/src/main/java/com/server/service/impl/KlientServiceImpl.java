package com.server.service.impl;

import com.server.dto.AllKlientDto;
import com.server.dto.KlientRegistrationDto;
import com.server.model.Adres;
import com.server.model.users.Klient;
import com.server.repository.KlientRepository;
import com.server.repository.UserRepository;
import com.server.repository.UserRoleRepository;
import com.server.service.AdresService;
import com.server.service.KlientService;
import com.server.service.dtoconverters.BaseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KlientServiceImpl implements KlientService {

    KlientRepository klientRepository;
    UserRepository userRepository;
    UserRoleRepository userRoleRepository;
    BaseConverter<Klient, AllKlientDto> baseConverter;
    BaseConverter<KlientRegistrationDto,Klient> registrationBaseConverter;
    AdresService adresService;

    @Autowired
    KlientServiceImpl(KlientRepository klientRepository, UserRepository userRepository, UserRoleRepository userRoleRepository, BaseConverter<Klient, AllKlientDto> baseConverter, BaseConverter<KlientRegistrationDto, Klient> registrationBaseConverter, AdresService adresService){
        this.klientRepository=klientRepository;
        this.userRepository=userRepository;
        this.userRoleRepository=userRoleRepository;
        this.baseConverter=baseConverter;
        this.registrationBaseConverter=registrationBaseConverter;
        this.adresService=adresService;
    }

    @Override
    public void addKlient(KlientRegistrationDto userDto) {

        String DEFAULT_ROLE="ROLE_USER";
        String ROLE_KLIENT="ROLE_KLIENT";

        //User user=new User();

        Klient klient=registrationBaseConverter.convert(userDto);
        klient.getUser().getRoles().add(userRoleRepository.getByRole(DEFAULT_ROLE));
        klient.getUser().getRoles().add(userRoleRepository.getByRole(ROLE_KLIENT));

        Adres adresFromDto = klient.getAdres();

        Adres adresFromdDatabase = adresService.getByAllColumns(adresFromDto.getKodpocztowy(),adresFromDto.getMiejscowosc(),adresFromDto.getUlica(),adresFromDto.getNumerdomu(),adresFromDto.getNrlokalu());

        if(adresFromdDatabase!=null)
            klient.setAdres(adresFromdDatabase);

        //System.out.println(klient.getUser().getNazwisko());

        klientRepository.save(klient);
    }

    @Override
    public void updateKlient(Klient klient) {
        klientRepository.save(klient);
    }

    @Override
    public void deleteKlient(Klient klient) {
        klientRepository.delete(klient);
    }

    @Override
    public List<AllKlientDto> getAllKlients() {

        List<AllKlientDto> klientDtos=baseConverter.convertAll(klientRepository.findAll());
        return klientDtos;
    }

    @Override
    public Klient getByUsername(String username) {
        return userRepository.getByUsername(username).getKlient();
    }

    @Override
    public Klient getById(Long id) {
        return klientRepository.getByid(id);
    }
}

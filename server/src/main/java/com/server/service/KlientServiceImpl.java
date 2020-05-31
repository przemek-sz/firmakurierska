package com.server.service;

import com.server.dto.AllKlientDto;
import com.server.dto.KlientRegistrationDto;
import com.server.model.Klient;
import com.server.repository.KlientRepository;
import com.server.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KlientServiceImpl implements KlientService {

    KlientRepository klientRepository;
    UserRoleRepository userRoleRepository;
    BaseConverter<Klient, AllKlientDto> baseConverter;
    BaseConverter<KlientRegistrationDto,Klient> registrationBaseConverter;

    @Autowired
    KlientServiceImpl(KlientRepository klientRepository, UserRoleRepository userRoleRepository, BaseConverter<Klient, AllKlientDto> baseConverter, BaseConverter<KlientRegistrationDto, Klient> registrationBaseConverter){
        this.klientRepository=klientRepository;
        this.userRoleRepository=userRoleRepository;
        this.baseConverter=baseConverter;
        this.registrationBaseConverter=registrationBaseConverter;
    }

    @Override
    public void addUser(KlientRegistrationDto userDto) {

        String DEFAULT_ROLE="ROLE_USER";

        //User user=new User();

        Klient klient=registrationBaseConverter.convert(userDto);
        klient.getRoles().add(userRoleRepository.getByRole(DEFAULT_ROLE));

        klientRepository.save(klient);
    }

    @Override
    public void updateUser(Klient klient) {
        klientRepository.save(klient);
    }

    @Override
    public void removeUser(Klient klient) {
        klientRepository.delete(klient);
    }

    @Override
    public List<AllKlientDto> getAllUsers() {

        List<AllKlientDto> klientDtos=baseConverter.convertAll(klientRepository.findAll());
        return klientDtos;
    }

    @Override
    public Klient getByusername(String username) {
        return klientRepository.getByusername(username);
    }

    @Override
    public Klient getByid(Long id) {
        return klientRepository.getByid(id);
    }
}

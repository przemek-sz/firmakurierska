package com.server.service.impl;

import com.server.dto.PracownikDto;
import com.server.dto.PracownikSortowniDto;
import com.server.model.users.Pracownik;
import com.server.model.users.PracownikSortowni;
import com.server.model.users.User;
import com.server.repository.KurierRepository;
import com.server.repository.PracownikRepository;
import com.server.repository.PracownikSortowniRepository;
import com.server.repository.UserRoleRepository;
import com.server.service.PracownikSortowniService;
import com.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class PracownikSortowniImpl implements PracownikSortowniService {

    UserService userService;
    PracownikRepository pracownikRepository;
    PracownikSortowniRepository pracownikSortowniRepository;
    KurierRepository kurierRepository;
    UserRoleRepository userRoleRepository;

    @Autowired
    public PracownikSortowniImpl(UserService userService, PracownikRepository pracownikRepository, PracownikSortowniRepository pracownikSortowniRepository, KurierRepository kurierRepository, UserRoleRepository userRoleRepository){
        this.userService=userService;
        this.pracownikRepository=pracownikRepository;
        this.pracownikSortowniRepository=pracownikSortowniRepository;
        this.kurierRepository=kurierRepository;
        this.userRoleRepository=userRoleRepository;
    }



    @Override
    public void addPracownikSortowni(PracownikSortowniDto dto) {

        User user;
        Pracownik pracownik;
        PracownikSortowni pracownikSortowni;
        String PRACOWNIK_ROLE="ROLE_PRACOWNIK";

        user = userService.getByusername(dto.getUsername());
        if(user==null){
            user=new User();
            user.setUsername(dto.getUsername());
            user.setPassword("12345");
            user.setEmail(dto.getUsername()+"@"+"kurierska.pl");
            user.setImie(dto.getImie());
            user.setNazwisko(dto.getNazwisko());
            user.getRoles().add(userRoleRepository.getByRole(PRACOWNIK_ROLE));


            pracownik = new Pracownik();
            pracownik.setDataZatrudnienia(LocalDate.now());

            pracownikSortowni = new PracownikSortowni();
            pracownikSortowni.setNazwaDzialu(dto.getNazwaDzialu());

            user.setPracownik(pracownik);
            pracownik.setUser(user);

            pracownik.setPracownikSortowni(pracownikSortowni);
            pracownikSortowni.setPracownik(pracownik);

            userService.addUser(user);


        }else {

            pracownik = user.getPracownik();

            if(pracownik == null){
                pracownik = new Pracownik();
                pracownik.setDataZatrudnienia(LocalDate.now());

                pracownikSortowni = new PracownikSortowni();
                pracownikSortowni.setNazwaDzialu(dto.getNazwaDzialu());

                user.setPracownik(pracownik);
                pracownik.setUser(user);

                pracownik.setPracownikSortowni(pracownikSortowni);
                pracownikSortowni.setPracownik(pracownik);

                userService.updateUser(user);
            }
            else{
                if(pracownik.getKurier()!=null){
                    pracownik.getKurier().setPracownik(null);
                    kurierRepository.save(pracownik.getKurier());
                }

                pracownik.setKurier(null);

                if(pracownik.getPracownikSortowni()!=null){
                     pracownik.getPracownikSortowni().setPracownik(null);
                     pracownikSortowniRepository.save(pracownik.getPracownikSortowni());
                }

                pracownik.setPracownikSortowni(null);

                pracownikSortowni = new PracownikSortowni();
                pracownikSortowni.setNazwaDzialu(dto.getNazwaDzialu());

                user.setPracownik(pracownik);
                pracownik.setUser(user);

                pracownik.setPracownikSortowni(pracownikSortowni);
                pracownikSortowni.setPracownik(pracownik);

                userService.updateUser(user);

            }

        }


    }
}


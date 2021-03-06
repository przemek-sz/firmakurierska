package com.server.service.impl;

import com.server.dto.KurierDto;
import com.server.dto.PracownikSortowniDto;
import com.server.model.users.Kurier;
import com.server.model.users.Pracownik;
import com.server.model.users.PracownikSortowni;
import com.server.model.users.User;
import com.server.repository.KurierRepository;
import com.server.repository.PracownikRepository;
import com.server.repository.PracownikSortowniRepository;
import com.server.repository.UserRoleRepository;
import com.server.service.KurierService;
import com.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class KurierServiceImpl implements KurierService {

    private KurierRepository kurierRepository;
    UserService userService;
    PracownikRepository pracownikRepository;
    PracownikSortowniRepository pracownikSortowniRepository;
    UserRoleRepository userRoleRepository;

    @Autowired
    KurierServiceImpl(UserService userService, PracownikRepository pracownikRepository, PracownikSortowniRepository pracownikSortowniRepository, KurierRepository kurierRepository, UserRoleRepository userRoleRepository){
        this.userService=userService;
        this.pracownikRepository=pracownikRepository;
        this.pracownikSortowniRepository=pracownikSortowniRepository;
        this.kurierRepository=kurierRepository;
        this.userRoleRepository=userRoleRepository;
    }


    @Override
    public void addKurier(KurierDto dto) {

        User user;
        Pracownik pracownik;
        Kurier kurier;
        String KURIER_ROLE="ROLE_KURIER";

        user = userService.getByusername(dto.getUsername());
        if(user==null){
            user=new User();
            user.setUsername(dto.getUsername());
            user.setPassword("12345");
            user.setEmail(dto.getUsername()+"@"+"kurierska.pl");
            user.setImie(dto.getImie());
            user.setNazwisko(dto.getNazwisko());
            user.getRoles().add(userRoleRepository.getByRole(KURIER_ROLE));


            pracownik = new Pracownik();
            pracownik.setDataZatrudnienia(LocalDate.now());

            kurier=new Kurier();

            user.setPracownik(pracownik);
            pracownik.setUser(user);

            pracownik.setKurier(kurier);
            kurier.setPracownik(pracownik);

            userService.addUser(user);

        }else {

            pracownik = user.getPracownik();

            if(pracownik == null){
                pracownik = new Pracownik();
                pracownik.setDataZatrudnienia(LocalDate.now());

                kurier = new Kurier();

                user.setPracownik(pracownik);
                pracownik.setUser(user);

                pracownik.setKurier(kurier);
                kurier.setPracownik(pracownik);

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

                kurier = new Kurier();

                user.setPracownik(pracownik);
                pracownik.setUser(user);

                pracownik.setKurier(kurier);
                kurier.setPracownik(pracownik);

                userService.updateUser(user);

            }

        }


    }

    @Override
    public void updateKurier(Kurier kurier) {

    }

    @Override
    public void removeKurier(Kurier kurier) {

    }

    @Override
    public List<Kurier> getKurierList() {
        return kurierRepository.findAll();
    }

    @Override
    public Kurier getByusername(String username) {
        return null;
    }

    @Override
    public Kurier getByid(Long id) {
        return null;
    }
}

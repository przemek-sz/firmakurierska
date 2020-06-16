package com.server.service.dtoconverters;

import com.server.dto.KlientRegistrationDto;
import com.server.model.Adres;
import com.server.model.users.Klient;
import com.server.model.users.User;
import org.springframework.stereotype.Service;

@Service
public class DtoToKlientConverter implements BaseConverter<KlientRegistrationDto, Klient>{
    @Override
    public Klient convert(KlientRegistrationDto from) {

        User user = new User();
        Klient klient = new Klient();
        Adres adres = new Adres();

        user.setUsername(from.getUsername());
        user.setPassword(from.getPassword());
        user.setEmail(from.getEmail());
        user.setImie(from.getImie());
        user.setNazwisko(from.getNazwisko());
        user.setKlient(klient);
        klient.setUser(user);
        klient.setAdres(adres);

        adres.setKodpocztowy(from.getKodpocztowy());
        adres.setMiejscowosc(from.getMiejscowosc());
        adres.setUlica(from.getUlica());
        adres.setNumerdomu(from.getNumerdomu());
        adres.setNrlokalu(from.getNrlokalu());

        return klient;
    }
}

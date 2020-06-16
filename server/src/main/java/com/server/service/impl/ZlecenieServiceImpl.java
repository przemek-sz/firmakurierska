package com.server.service.impl;

import com.server.model.Sortownia;
import com.server.model.Status;
import com.server.model.users.Kurier;
import com.server.model.Przesylka;
import com.server.model.users.User;
import com.server.model.Zlecenie;
import com.server.repository.SortowniaRepository;
import com.server.repository.ZlecenieRepository;
import com.server.service.KurierService;
import com.server.service.ZlecenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ZlecenieServiceImpl implements ZlecenieService {

    ZlecenieRepository zlecenieRepository;
    KurierService kurierService;
    SortowniaRepository sortowniaRepository;

    @Autowired
    ZlecenieServiceImpl(ZlecenieRepository zlecenieRepository, KurierService kurierServicey, SortowniaRepository sortowniaRepository){
        this.zlecenieRepository=zlecenieRepository;
        this.kurierService=kurierServicey;
        this.sortowniaRepository=sortowniaRepository;
    }


    @Override
    public void addZlecenie(Zlecenie zlecenie) {
        zlecenieRepository.save(zlecenie);
    }

    @Override
    public Zlecenie createZlecenieOdbioruOdKlienta(Przesylka przesylka) {

        Zlecenie zlecenie = new Zlecenie();
        List<Kurier> kurierzy = kurierService.getKurierList();
        List<Sortownia> sortownie= sortowniaRepository.findAll();

        zlecenie.setPrzesylka(przesylka);
        zlecenie.setStatus(Status.WTRAKCIEREALIZACJI);
        zlecenie.setDataUtworzenia(new Date());
        zlecenie.setAdresodbioru(przesylka.getNadawca().getAdres());
        if(kurierzy.size()<1)
            zlecenie.setKurier(null);
        else
        zlecenie.setKurier(kurierzy.get(new Random().nextInt(kurierzy.size())));
        if(sortownie.size()<1)
            zlecenie.setKurier(null);
        else
            zlecenie.setAdresdostarczenia(sortownie.get(new Random().nextInt(kurierzy.size())).getAdres());


        return zlecenie;
    }

    @Override
    public void updateZlecenie(Zlecenie zlecenie) {

    }

    @Override
    public User getByid(Long id) {
        return null;
    }
}

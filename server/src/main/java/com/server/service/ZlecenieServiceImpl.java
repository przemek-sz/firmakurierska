package com.server.service;

import com.server.model.Kurier;
import com.server.model.Przesylka;
import com.server.model.User;
import com.server.model.Zlecenie;
import com.server.repository.KurierRepository;
import com.server.repository.ZlecenieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ZlecenieServiceImpl implements ZlecenieService{

    ZlecenieRepository zlecenieRepository;
    KurierService kurierService;

    @Autowired
    ZlecenieServiceImpl(ZlecenieRepository zlecenieRepository, KurierService kurierServicey){
        this.zlecenieRepository=zlecenieRepository;
        this.kurierService=kurierServicey;
    }


    @Override
    public void addZlecenie(Zlecenie zlecenie) {
        zlecenieRepository.save(zlecenie);
    }

    @Override
    public Zlecenie createZlecenieOdbioruOdKlienta(Przesylka przesylka) {

        Zlecenie zlecenie = new Zlecenie();
        List<Kurier> kurierzy = kurierService.getKurierList();

        zlecenie.setPrzesylka(przesylka);
        zlecenie.setStatus("w_trakcie_realizacji");
        zlecenie.setTyp("odbior_od_klienta");
        zlecenie.setDataUtworzenia(new Date());
        zlecenie.setAdresodbioru(przesylka.getNadawca().getAdres());
        if(kurierzy.size()<1)
            zlecenie.setKurier(null);
        else
        zlecenie.setKurier(kurierzy.get(new Random().nextInt(kurierzy.size())));

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

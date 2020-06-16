package com.server.service.impl;

import com.server.model.users.Kurier;
import com.server.repository.KurierRepository;
import com.server.service.KurierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KurierServiceImpl implements KurierService {

    private KurierRepository kurierRepository;

    @Autowired
    KurierServiceImpl(KurierRepository kurierRepository){
        this.kurierRepository=kurierRepository;
    }


    @Override
    public void addKurier(Kurier kurier) {

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

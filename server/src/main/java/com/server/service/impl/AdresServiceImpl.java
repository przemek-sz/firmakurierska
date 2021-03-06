package com.server.service.impl;

import com.server.model.Adres;
import com.server.repository.AdresRepository;
import com.server.service.AdresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdresServiceImpl implements AdresService {

    private AdresRepository adresRepository;

    @Autowired
    AdresServiceImpl(AdresRepository adresRepository){
        this.adresRepository=adresRepository;
    }

    @Override
    public void addAdres(Adres adres) {
        adresRepository.save(adres);
    }

    @Override
    public void updateAdres(Adres adres) {

    }

    @Override
    public void removeAdres(Adres adres) {

    }

    @Override
    public Adres getById(Long id) {
        return adresRepository.getOne(id);
    }

    @Override
    public Adres getByAllColumns(String kod, String miejscowosc, String ulica, String nrdomu, String nrlokalu) {

        return adresRepository.getAdresByKodpocztowyAndMiejscowoscAndUlicaAndNumerdomuAndNrlokalu(kod, miejscowosc, ulica, nrdomu, nrlokalu);
    }
}

package com.server.service;


import com.server.dto.KurierDto;
import com.server.model.users.Kurier;

import java.util.List;

public interface KurierService{

    public void addKurier(KurierDto kurierDto);
    public void updateKurier(Kurier kurier);
    public void removeKurier(Kurier kurier);
    public List<Kurier> getKurierList();
    public Kurier getByusername(String username);
    public Kurier getByid(Long id);
}

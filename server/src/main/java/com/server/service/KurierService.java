package com.server.service;


import com.server.dto.AllUserDto;
import com.server.dto.UserRegistrationDto;
import com.server.model.Kurier;
import com.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KurierService {

    public void addKurier(Kurier kurier);
    public void updateKurier(Kurier kurier);
    public void removeKurier(Kurier kurier);
    public List<Kurier> getKurierList();
    public Kurier getByusername(String username);
    public Kurier getByid(Long id);
}

package com.server.repository;

import com.server.model.users.Klient;
import com.server.model.Przesylka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrzesylkaRepository extends JpaRepository<Przesylka,Long> {

    public List<Przesylka> getByNadawca(Klient klient);
}

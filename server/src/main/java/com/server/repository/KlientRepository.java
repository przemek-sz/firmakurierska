package com.server.repository;

import com.server.model.Klient;
import com.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlientRepository extends JpaRepository<Klient,Long> {

    public Klient getByusername(String username);
    public Klient getByid(Long id);
}

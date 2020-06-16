package com.server.repository;

import com.server.model.users.Klient;
import com.server.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlientRepository extends JpaRepository<Klient,Long> {

    public Klient getByUser(User user);
    public Klient getByid(Long id);
}

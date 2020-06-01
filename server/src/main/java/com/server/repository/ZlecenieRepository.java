package com.server.repository;


import com.server.model.Zlecenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZlecenieRepository extends JpaRepository<Zlecenie,Long> {
}

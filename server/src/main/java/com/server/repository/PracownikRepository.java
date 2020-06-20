package com.server.repository;

import com.server.model.users.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracownikRepository extends JpaRepository<Pracownik,Long> {
}

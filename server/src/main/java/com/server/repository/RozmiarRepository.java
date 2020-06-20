package com.server.repository;

import com.server.model.Rozmiar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RozmiarRepository extends JpaRepository<Rozmiar,Long> {
}

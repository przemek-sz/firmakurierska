package com.server.repository;

import com.server.model.Kurier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KurierRepository extends JpaRepository<Kurier,Long> {
}

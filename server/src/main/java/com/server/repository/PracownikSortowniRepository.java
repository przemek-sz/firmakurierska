package com.server.repository;

import com.server.model.users.PracownikSortowni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracownikSortowniRepository extends JpaRepository<PracownikSortowni,Long> {
}

package com.server.repository;

import com.server.model.Sortownia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortowniaRepository extends JpaRepository<Sortownia,Long> {
}

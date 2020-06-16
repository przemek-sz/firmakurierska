package com.server.repository;

import com.server.model.Typ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypRepository extends JpaRepository<Typ,Long> {

}

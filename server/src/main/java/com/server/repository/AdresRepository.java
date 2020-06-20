package com.server.repository;

import com.server.model.Adres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresRepository extends JpaRepository<Adres,Long> {

    public Adres getAdresByKodpocztowyAndMiejscowoscAndUlicaAndNumerdomuAndNrlokalu(String kod, String miejscowosc, String ulica, String nrdomu, String nrlokalu);
}

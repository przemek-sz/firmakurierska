package com.server.service;

import com.server.model.Typ;

import java.util.List;

public interface TypService {

    public List<Typ> getAll();

    public Typ getById(Long id);

}

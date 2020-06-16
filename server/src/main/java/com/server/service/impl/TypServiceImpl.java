package com.server.service.impl;

import com.server.model.Typ;
import com.server.repository.TypRepository;
import com.server.service.TypService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypServiceImpl implements TypService {

    private TypRepository typRepository;

    @Autowired
    public TypServiceImpl(TypRepository typRepository){
        this.typRepository =typRepository;
    }

    @Override
    public List<Typ> getAll() {
        return typRepository.findAll();
    }

    @Override
    public Typ getById(Long id) {
        return typRepository.getOne(id);
    }


}

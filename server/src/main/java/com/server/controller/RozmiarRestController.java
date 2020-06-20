package com.server.controller;

import com.server.dto.RozmiarDto;
import com.server.model.Rozmiar;
import com.server.model.Typ;
import com.server.repository.RozmiarRepository;
import com.server.service.TypService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rozmiar")
public class RozmiarRestController {

    private RozmiarRepository rozmiarRepository;

    @Autowired
    public RozmiarRestController(RozmiarRepository rozmiarRepository){
        this.rozmiarRepository=rozmiarRepository;
    }

    @GetMapping
    public List<RozmiarDto> getAll(){

        List<RozmiarDto> list = new ArrayList<>();

        for(Rozmiar r : rozmiarRepository.findAll()){
            RozmiarDto rozmiarDto = new RozmiarDto();
            rozmiarDto.setValue(r.getId().toString());
            rozmiarDto.setLabel(r.getRozmiar());
            list.add(rozmiarDto);
        }

        return list;
    }
}

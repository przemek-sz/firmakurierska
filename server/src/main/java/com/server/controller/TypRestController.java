package com.server.controller;

import com.server.model.Typ;
import com.server.service.TypService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/typ")
public class TypRestController {

    private TypService typService;

    @Autowired
    public TypRestController(TypService typService){
        this.typService=typService;
    }

    @GetMapping
    public List<Typ> getAll(){

        return typService.getAll();
    }
}

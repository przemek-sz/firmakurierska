package com.server.controller;

import com.server.dto.AllKlientDto;
import com.server.dto.KlientRegistrationDto;
import com.server.service.KlientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class KlientRestController {

    KlientService klientService;

    @Autowired
    KlientRestController(KlientService klientService){
        this.klientService=klientService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public void registerKlient(@RequestBody KlientRegistrationDto klientDto){
        System.out.println(klientDto.getUsername());
        klientService.addKlient(klientDto);

    }

    public void updateKlient(){

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AllKlientDto> getAllKlients(){
        return klientService.getAllKlients();
    }


    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void removeKlient(@PathVariable Long id){
        klientService.removeKlient(klientService.getById(id));
    }
}

package com.server.controller;

import com.server.dto.AllKlientDto;
import com.server.dto.AllPrzesylkaDto;
import com.server.dto.KlientRegistrationDto;
import com.server.dto.NowaPrzesylkaDto;
import com.server.service.PrzesylkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/przesylka")
public class PrzesylkaRestController {

    PrzesylkaService przesylkaService;

    @Autowired
    PrzesylkaRestController(PrzesylkaService przesylkaService){
        this.przesylkaService=przesylkaService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public AllPrzesylkaDto nadaniePrzesylki(@RequestBody @Validated NowaPrzesylkaDto nowaPrzesylkaDto, Principal principal){

        System.out.println(nowaPrzesylkaDto.toString());

        return przesylkaService.nowaPrzesylka(nowaPrzesylkaDto,principal.getName());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public AllPrzesylkaDto updatePrzesylka(@RequestBody NowaPrzesylkaDto nowaPrzesylkaDto, Principal principal){
        return przesylkaService.editPrzesylka(nowaPrzesylkaDto,principal.getName());
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<AllPrzesylkaDto> getAllPrzesylka(Principal principal){
        return przesylkaService.getAllPrzesylkaDto(principal.getName());
    }

    @RequestMapping(value="/anulowanie/{id}",method = RequestMethod.PUT)
    public void setAnulowana(@PathVariable Long id){
        przesylkaService.setAnulowana(id);
    }

}

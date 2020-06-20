package com.server.controller;

import com.server.dto.PracownikSortowniDto;
import com.server.model.users.PracownikSortowni;
import com.server.service.PracownikSortowniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pracowniksortowni")
public class PracownikSortowniRestController {

    PracownikSortowniService pracownikSortowniService;

    @Autowired
    public PracownikSortowniRestController(PracownikSortowniService pracownikSortowniService){
        this.pracownikSortowniService=pracownikSortowniService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addPracownikSortowni(@RequestBody PracownikSortowniDto pracownikSortowniDto){
        System.out.println(pracownikSortowniDto);
        pracownikSortowniService.addPracownikSortowni(pracownikSortowniDto);
    }
}

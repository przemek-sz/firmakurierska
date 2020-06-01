package com.server.controller;

import com.server.dto.AllKlientDto;
import com.server.dto.KlientRegistrationDto;
import com.server.service.KlientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    KlientService klientService;

    @Autowired
    UserRestController(KlientService klientService){
        this.klientService=klientService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody KlientRegistrationDto userDto){
        System.out.println(userDto.getUsername());
        System.out.println(userDto.getImieinazwisko());
        klientService.addKlient(userDto);

    }

    public void updateUser(){

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AllKlientDto> getAllUsers(){
        return klientService.getAllUsers();
    }

    //public User getUserByUserName(String userName){

    // return userService.getByUsername(userName);
    // }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void removeUser(@PathVariable Long id){
        klientService.removeUser(klientService.getByid(id));
    }
}

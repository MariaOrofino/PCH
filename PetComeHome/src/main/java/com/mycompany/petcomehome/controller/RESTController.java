/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.controller;

import com.mycompany.petcomehome.model.Pet;
import com.mycompany.petcomehome.service.LocSL;
import com.mycompany.petcomehome.service.PetSL;
import com.mycompany.petcomehome.service.UserSL;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author n0111557
 */
@CrossOrigin
@Controller
public class RESTController {

    private LocSL locService;
    private PetSL petService;
    private UserSL userService;

    @Inject

    public RESTController(LocSL LocService, PetSL PetService, UserSL UserService) {
        this.locService = LocService;
        this.petService = PetService;
        this.userService = UserService;
    }

    @RequestMapping(value= "/Pet", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Pet createPet(@RequestBody Pet pet){
        return petService.createPet(pet);
    }
}

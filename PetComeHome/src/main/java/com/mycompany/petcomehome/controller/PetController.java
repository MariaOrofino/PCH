package com.mycompany.petcomehome.controller;

import com.mycompany.petcomehome.service.LocSL;
import com.mycompany.petcomehome.service.PetSL;
import com.mycompany.petcomehome.service.UserSL;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class PetController {

    public static final String pictureFolder = "images/";
    LocSL locSL;
    PetSL petSL;
    UserSL userSL;

//    @Inject
    public PetController(LocSL locSL, PetSL petSL, UserSL userSL) {
        this.locSL = locSL;
        this.petSL = petSL;
        this.userSL = userSL;
    }

    public PetController() {
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String redirectHome() {
        return "redirect:/";
    }

//    @RequestMapping(value = "/submitForm", method = RequestMethod.GET)
//    public String editblog(HttpServletRequest request) {
//        return "submitForm";
//    }
}

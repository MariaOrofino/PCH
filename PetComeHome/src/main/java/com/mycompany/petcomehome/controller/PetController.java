package com.mycompany.petcomehome.controller;

import com.mycompany.petcomehome.service.LocSL;
import com.mycompany.petcomehome.service.PetSL;
import com.mycompany.petcomehome.service.UserSL;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/hello"})
public class PetController {

//    public static final String pictureFolder = "images/";
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

//    @RequestMapping(value = "/sayhi", method = RequestMethod.GET)
//    public String sayHi(Map<String, Object> model) {
//        model.put("message", "Hello from the controller");
//        return "hello";
//    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String redirectHome() {
        return "redirect:/";
    }
}

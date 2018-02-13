package com.mycompany.petcomehome.controller;

import com.mycompany.petcomehome.model.PetStatus;
import com.mycompany.petcomehome.model.PetType;
import com.mycompany.petcomehome.service.LocSL;
import com.mycompany.petcomehome.service.PetSL;
import com.mycompany.petcomehome.service.UserSL;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class PetController {

    public static final String pictureFolder = "C:\\My Data\\images/";
//<<<<<<< HEAD
//=======
//    public static final String pictureName = "http://localhost:8080/static/";   
//>>>>>>> 65f67a2034b471e6319598c54903dd4b31ca9466
    LocSL locSL;
    PetSL petSL;
    UserSL userSL;
    

//    @Inject
    public PetController(LocSL locSL, PetSL petSL, UserSL userSL) {
        this.locSL = locSL;
        this.petSL = petSL;
        this.userSL = userSL;
    }
//
//    public PetController() {
//        
//    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayHomePage(Model model) {

        List<PetType> typeList = listTypes();
        model.addAttribute("typeList", typeList);

        List<PetStatus> statusList = listStatus();
        model.addAttribute("statusList", statusList);

        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String redirectHome() {
        return "redirect:/";
    }

//    @RequestMapping(value = "/submitForm", method = RequestMethod.GET)
//    public String editblog(HttpServletRequest request) {
//        return "submitForm";
//    }
    private List<PetType> listTypes() {
        List<PetType> typeList = petSL.retrieveAllPetTypes();
        return typeList;
    }

    private List<PetStatus> listStatus() {
        List<PetStatus> statusList = petSL.retrieveAllPetStatuses();
        return statusList;
    }
}

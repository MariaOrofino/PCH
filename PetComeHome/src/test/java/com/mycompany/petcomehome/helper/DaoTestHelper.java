package com.mycompany.petcomehome.helper;

import com.mycompany.petcomehome.dao.*;
import com.mycompany.petcomehome.model.*;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoTestHelper {

    @Inject
    LocDao locDao;
    PetDao petDao;
    PetStatusDao petStatusDao;
    PetTypeDao petTypeDao;
    UserDao userDao;

    private static final Loc createLoc(int num){
        Loc loc = new Loc();
        loc.setLocId(num);
        loc.setLocName("Elysian Fields" + num);
        loc.setLocDesc("Rolling hills of green");
        loc.setLocAddress("150 Liberty Way");
        loc.setLocCity("Dover");
        loc.setLocState("NH");
        loc.setLocZip("03820");
        loc.setLocInd("locInd");
        loc.setLocLat(new BigDecimal("42.7509976"));
        loc.setLocLong(new BigDecimal("-71.4833652"));
        return loc;
    }

    private static final Pet createPet(int num){
        Pet pet = new Pet();
        pet.setPetId(num);
        pet.setPetName("Ellington" + num);
        pet.setPetDesc("Lovable");
        pet.setPetChipTag("SAHD2829903JJQW");
        pet.setPetRabiesTag("NAS38217");
        pet.setPetBreed("Domestic Shorthair Cat");
        pet.setPetSize("Medium Small");
        pet.setPetColor("Black");
        pet.setPetImgURL("000001.jpg");
        pet.setPetCreateDate(LocalDate.parse("01-02-2018"));
        pet.setPetModifiedDate(LocalDate.parse("01-08-2018"));
        pet.setPetLostDate(LocalDate.parse("01-01-2018"));
        pet.setPetFoundDate(LocalDate.parse("01-15-2018"));
        pet.setPetSightedDate(LocalDate.parse("01-12-2018"));
        List<User> userList = new ArrayList<>();
        List<Loc> locList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            userList.add(createUser(i));
            locList.add(createLoc(i));
        }
        pet.setUser(userList);
        pet.setLoc(locList);
        pet.setPetStatus(createPetStatus(num));
        pet.setPetType(createPetType(num));
        return pet;
    }

    private static final PetStatus createPetStatus (int num){
        PetStatus petStatus = new PetStatus();
        petStatus.setPetStatusId(num);
        petStatus.setPetStatus("petStatus");
        return petStatus;
    }

    private static final PetType createPetType (int num) {
        PetType petType = new PetType();
        petType.setPetTypeId(num);
        petType.setPetSpec("Cat");
        petType.setOther("N/A");
        return petType;
    }

    private static final User createUser (int num){
        User user = new User();
        user.setUserId(num);
        user.setUserLogin("catLover123");
        user.setUserPassword("password");
        user.setUserFirstName("Joe");
        user.setUserLastName("Smith");
        user.setUserCity("Portsmouth");
        user.setUserState("NH");
        user.setUserZip("03801");
        user.setUserMobile("6035551212");
        user.setUserAltPhone("6175551212");
        user.setUserEmail("catLover123@myspace.com");
        user.setUserAltEmail("catlover123@altavista.com");
        return user;
    }
}

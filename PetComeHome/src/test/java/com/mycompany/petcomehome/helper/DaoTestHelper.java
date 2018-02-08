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

    public static final Loc createLoc(int num) {
        Loc loc = new Loc();
        loc.setLocId(num);
        loc.setLocName("Elysian Fields" + num);
        loc.setLocDesc("Rolling hills of green");
        loc.setLocCity("Dover");
        loc.setLocState("NH");
        loc.setLocZip("03820");
        loc.setLocInd("L");
        loc.setLocLat(new Double("42.7509976"));
        loc.setLocLong(new Double("-71.4833652"));
        return loc;
    }

    public static final Pet createPet(int num) {

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
        pet.setPetTypeId(num);
        pet.setPetCreateDate(LocalDate.parse("2018-01-02"));
        pet.setPetModifiedDate(LocalDate.parse("2018-01-08"));
        pet.setPetLostDate(LocalDate.parse("2018-01-01"));
        pet.setPetFoundDate(LocalDate.parse("2018-01-15"));
        pet.setPetSightedDate(LocalDate.parse("2018-01-12"));
        pet.setPetStatusId(num);
        User newUser = createUser(1);            

        List<Loc> locList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            locList.add(createLoc(i));
        }
        pet.setUser(newUser);
        pet.setLoc(locList);
//        pet.setPetStatus(createPetStatus(num));
//        pet.setPetType(createPetType(num));
        return pet;
    }

//    public static final PetStatus createPetStatus(int num) {
//        PetStatus petStatus = new PetStatus();
//        petStatus.setPetStatusId(num);
//        petStatus.setPetStatus("LOST");
//        return petStatus;
//    }
//
//    public static final PetType createPetType(int num) {
//        PetType petType = new PetType();
//        petType.setPetTypeId(num);
//        petType.setPetSpec("Dog");
//        petType.setOther("N/A");
//        return petType;
//    }

    public static final User createUser(int num) {
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

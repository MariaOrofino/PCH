/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.service;

import com.mycompany.petcomehome.model.Loc;
import com.mycompany.petcomehome.model.Pet;
import com.mycompany.petcomehome.model.PetStatus;
import com.mycompany.petcomehome.model.PetType;
import com.mycompany.petcomehome.model.User;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author n0263892
 */
public class PetSLTest {

    private UserSL userSL;
    private LocSL locSL;
    private PetSL petSL;

    Pet myNewPet;

    List<Loc> locList = new ArrayList<>();
    List<User> userList = new ArrayList<>();
    List<Pet> petList = new ArrayList<>();
    Pet usedPet;

    Loc newLoc = new Loc();
    User newUser = new User();
    Pet newPet = new Pet();

    public PetSLTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        petSL = ctx.getBean("petSL", PetSL.class);
        userSL = ctx.getBean("userSL", UserSL.class);
        locSL = ctx.getBean("locSL", LocSL.class);

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        userList = userSL.retrieveAllUsers();
        for (User currentUser : userList) {
            userSL.deleteUser(currentUser.getUserId());
        }

        locList = locSL.retrieveAllLocs();
        for (Loc currentLoc : locList) {
            locSL.deleteLoc(currentLoc.getLocId());
        }

        petList = petSL.getAllPets();
        for (Pet currentPet : petList) {
            petSL.deletePet(currentPet.getPetId());
        }

//        newUser.setUserId(1);
//        newUser.setUserLogin("catLover123");
//        newUser.setUserPassword("password");
//        newUser.setUserFirstName("Joe");
//        newUser.setUserLastName("Smith");
//        newUser.setUserCity("Portsmouth");
//        newUser.setUserState("NH");
//        newUser.setUserZip("03801");
//        newUser.setUserMobile("6035551212");
//        newUser.setUserAltPhone("6175551212");
//        newUser.setUserEmail("catLover123@myspace.com");
//        newUser.setUserAltEmail("catlover123@altavista.com");
//        userSL.createUser(newUser);
//        userList.add(newUser);
//
//        newLoc.setLocId(1);
//        newLoc.setLocName("Elysian Fields");
//        newLoc.setLocDesc("Rolling hills of green");
//        newLoc.setLocCity("Dover");
//        newLoc.setLocState("NH");
//        newLoc.setLocZip("03820");
//        newLoc.setLocInd("L");
//        newLoc.setLocLat(new Double("42.7509976"));
//        newLoc.setLocLong(new Double("-71.4833652"));
//        locSL.createLoc(newLoc);
//        locList.add(newLoc);
//
//        newPet.setPetId(1);
//        newPet.setPetName("Ellington");
//        newPet.setPetDesc("Lovable");
//        newPet.setPetChipTag("SAHD2829903JJQW");
//        newPet.setPetRabiesTag("NAS38217");
//        newPet.setPetBreed("Domestic Shorthair Cat");
//        newPet.setPetSize("Medium Small");
//        newPet.setPetColor("Black");
//        newPet.setPetImgURL("000001.jpg");
//        newPet.setPetCreateDate(LocalDate.parse("2018-01-02"));
//        newPet.setPetModifiedDate(LocalDate.parse("2018-01-08"));
//        newPet.setPetLostDate(LocalDate.parse("2018-01-01"));
//        newPet.setPetFoundDate(LocalDate.parse("2018-01-15"));
//        newPet.setPetSightedDate(LocalDate.parse("2018-01-12"));
//
//        PetStatus petStatus = new PetStatus();
//        petStatus.setPetStatusId(1);
//        petStatus.setPetStatus("LOST");
//
//        PetType petType = new PetType();
//        petType.setPetTypeId(1);
//        petType.setPetSpec("Dog");
//        petType.setOther("N/A");
//
//        newPet.setPetStatus(petStatus);
//        newPet.setPetType(petType);
//        newPet.setUser(userList);
//        newPet.setLoc(locList);
//        petSL.createPet(newPet);
    }

    @After
    public void tearDown() {

    }

    /**
     * Test of createPet method, of class PetSL.
     */
    @Test
    public void testCreatePet() {

//        Pet petFromDB = petSL.getPetByPetId(newPet.getPetId());
//        assertEquals(newPet, petFromDB);
//        assertNotNull(locList);
//        assertNotNull(userList);

    }

    /**
     * Test of updatePet method, of class PetSL.
     */
    @Test
    public void testUpdatePet() {
    }

    /**
     * Test of deletePet method, of class PetSL.
     */
    @Test
    public void testDeletePet() {
    }

    /**
     * Test of getPetByPetId method, of class PetSL.
     */
    @Test
    public void testGetPetByPetId() {
    }

    /**
     * Test of getPetbyuserId method, of class PetSL.
     */
    @Test
    public void testGetPetbyuserId() {
    }

    /**
     * Test of getPetByLocId method, of class PetSL.
     */
    @Test
    public void testGetPetByLocId() {
    }

    /**
     * Test of getAllPets method, of class PetSL.
     */
    @Test
    public void testGetAllPets() {
    }

}

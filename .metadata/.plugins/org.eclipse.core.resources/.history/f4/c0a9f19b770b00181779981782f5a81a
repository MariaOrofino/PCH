/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.service;

import com.mycompany.petcomehome.helper.DaoTestHelper;
import com.mycompany.petcomehome.model.Loc;
import com.mycompany.petcomehome.model.Pet;
import com.mycompany.petcomehome.model.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author n0000991
 */
public class LocServiceImplTest {

    LocSL locSL;
    PetSL petSL;
    UserSL userSL;
    Loc newLoc;
    List<Loc> locList;

    public LocServiceImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        locSL = ctx.getBean("locSL", LocSL.class);
        petSL = ctx.getBean("petSL", PetSL.class);
        userSL = ctx.getBean("userSL", UserSL.class);

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        locList = locSL.retrieveAllLocs();
        for (Loc currentLoc : locList) {
            locSL.deleteLoc(currentLoc.getLocId());
        }
        newLoc = DaoTestHelper.createLoc(1);
        locSL.createLoc(newLoc);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createLoc method, of class LocServiceImpl.
     */
    @Test
    public void testCreateLoc() {
        Loc locFromDB = locSL.retrieveLocByLocId(newLoc.getLocId());
        assertEquals(newLoc, locFromDB);
    }

    /**
     * Test of editLoc method, of class LocServiceImpl.
     */
    @Test
    public void testEditLoc() {
        newLoc.setLocState("MA");
        locSL.editLoc(newLoc);
        assertEquals("MA", newLoc.getLocState());
    }

    /**
     * Test of deleteLoc method, of class LocServiceImpl.
     */
    @Test
    public void testDeleteLoc() {
        locSL.deleteLoc(newLoc.getLocId());
        assertEquals(0, locSL.retrieveAllLocs().size());
    }

    /**
     * Test of retrieveLocByLocId method, of class LocServiceImpl.
     */
    @Test
    public void testRetrieveLocByLocId() {
        Loc oneLoc = locSL.retrieveLocByLocId(newLoc.getLocId());
        assertEquals(newLoc, oneLoc);

    }

    /**
     * Test of retrieveAllLocs method, of class LocServiceImpl.
     */
    @Test
    public void testRetrieveAllLocs() {
        List<Loc> newLocList = locSL.retrieveAllLocs();
        for (Loc currentLoc : newLocList) {
            assertEquals(newLoc.getLocId(), currentLoc.getLocId());
        }
    }

    /**
     * Test of retrieveLocsByPet method, of class LocServiceImpl.
     */
    @Test
    public void testRetrieveLocsByPet() {
//        List<User> newUserList = userSL.retrieveAllUsers();
//        for (User currentUser : newUserList) {
//            userSL.deleteUser(currentUser.getUserId());
//        }
//
//        List< Pet> newPetList = petSL.getAllPets();
//        for (Pet currentPet : newPetList) {
//            petSL.deletePet(currentPet.getPetId());
//        }
//        Pet newPet = DaoTestHelper.createPet(1);
//        List<Loc> newLocList = new ArrayList<>();
//        for (Loc currentLoc : newPet.getLoc()) {
//            locSL.createLoc(currentLoc);
//            newLocList.add(currentLoc);
//        }
//      
//        User newUser = userSL.createUser(newPet.getUser());
//
//        newPet.setLoc(null);
//        newPet.setLoc(newLocList);
////        newPet.setUser(null);
//        newPet.setUser(newUser);
//        petSL.createPet(newPet);
//        List<Loc> locPetList = locSL.retrieveLocsByPet(newPet.getPetId());
//
////  Test template for testing all the locations aligned with a petid
////        for (Loc currentLoc : newPet.getLoc()) {
////            assertEquals(newPet.getLoc(), currentLoc);
////        }
//        assertNotNull(locPetList);
//        assertEquals(5, locSL.retrieveLocsByPet(newPet.getPetId()).size());
//    }
}

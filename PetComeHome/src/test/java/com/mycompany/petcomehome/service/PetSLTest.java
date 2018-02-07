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
import static org.junit.Assert.assertNotNull;

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
    List<Loc> newLocList = new ArrayList<>();
    List<User> userList = new ArrayList<>();
    List<Pet> petList = new ArrayList<>();

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

        locList = locSL.retrieveAllLocs();
        for (Loc currentLoc : locList) {
            locSL.deleteLoc(currentLoc.getLocId());
        }

        petList = petSL.retrieveAllPets();
        for (Pet currentPet : petList) {
            petSL.deletePet(currentPet.getPetId());
        }

        userList = userSL.retrieveAllUsers();
        for (User currentUser : userList) {
            userSL.deleteUser(currentUser.getUserId());
        }

        newPet = DaoTestHelper.createPet(1);
//        locList = locSL.retrieveLocsByPet(newPet.getPetId());

//        newLocList = new ArrayList<>();
        for (Loc currentLoc : newPet.getLoc()) {
            Loc addedLoc = locSL.createLoc(currentLoc);
            newLocList.add(addedLoc);
        }

        newPet.setLoc(newLocList);
        User addedUser = userSL.createUser(newPet.getUser());
        newPet.setUser(addedUser);

        petSL.createPet(newPet);
    }

    @After
    public void tearDown() {

    }

    /**
     * Test of createPet method, of class PetSL.
     */
    @Test
    public void testCreatePet() {
        assertNotNull(newLocList);
        assertNotNull(newPet.getUser());
        assertNotNull(newPet);
    }

    /**
     * Test of updatePet method, of class PetSL.
     */
    @Test
    public void testUpdatePet() {
        newPet.setPetDesc("This is a test of Update!");
        petSL.updatePet(newPet);
        Pet fromDB = petSL.retrievePetByPetId(newPet.getPetId());
        assertEquals(fromDB.getPetDesc(), newPet.getPetDesc());
    }

    /**
     * Test of deletePet method, of class PetSL.
     */
    @Test
    public void testDeletePet() {
        petSL.deletePet(newPet.getPetId());
        Pet deletedPet = petSL.retrievePetByPetId(newPet.getPetId());
        assertEquals(null, newPet.getPetId());
    }

    /**
     * Test of retrievePetByPetId method, of class PetSL.
     */
    @Test
    public void testRetrievePetByPetId() {
    }

    /**
     * Test of retrievePetByUserId method, of class PetSL.
     */
    @Test
    public void testRetrievePetbyuserId() {
    }

    /**
     * Test of retrievePetByLocId method, of class PetSL.
     */
    @Test
    public void testRetrievePetByLocId() {
    }

    /**
     * Test of retrieveAllPets method, of class PetSL.
     */
    @Test
    public void testRetrieveAllPets() {
    }

}

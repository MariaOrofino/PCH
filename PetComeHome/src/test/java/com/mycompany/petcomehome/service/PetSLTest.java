/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.service;

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
import com.mycompany.petcomehome.helper.DaoTestHelper;
import java.util.ArrayList;
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
    List<User> userList = new ArrayList<>();
    List<Pet> petList = new ArrayList<>();

    Loc newLoc;
    User newUser;
    Pet newPet;

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

        List<User> removeUserList = userSL.retrieveAllUsers();
        for (User currentUser : removeUserList) {
            userSL.deleteUser(currentUser.getUserId());
        }

        List<Loc> removeLocList = locSL.retrieveAllLocs();
        for (Loc currentLoc : removeLocList) {
            locSL.deleteLoc(currentLoc.getLocId());
        }

        List<Pet> removePetList = petSL.getAllPets();
        for (Pet currentPet : removePetList) {
            petSL.deletePet(currentPet.getPetId());
        }

        List<Loc> newLocList = locSL.retrieveLocsByPet(newPet.getPetId());
        for (Loc currentLoc : newLocList) {
            locSL.createLoc(currentLoc);
            newLocList.add(currentLoc);
        }
        
        List<User> newUserList = userSL.retrieveUsersByPet(newPet.getPetId());
        for (User currentUser : newUserList) {
            userSL.createUser(currentUser);
            newUserList.add(currentUser);
        }

        Pet newPet = DaoTestHelper.createPet(1);

        newPet.setLoc(null);
        newPet.setLoc(newLocList);
        newPet.setUser(null);
        newPet.setUser(newUserList);
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
        assertNotNull(newPet);
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

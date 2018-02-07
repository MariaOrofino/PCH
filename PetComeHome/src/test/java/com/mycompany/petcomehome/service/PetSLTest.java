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

        petList = petSL.getAllPets();
        for (Pet currentPet : petList) {
            petSL.deletePet(currentPet.getPetId());
        }

        userList = userSL.retrieveAllUsers();
        for (User currentUser : userList) {
            userSL.deleteUser(currentUser.getUserId());
        }

        newPet = DaoTestHelper.createPet(1);
        locList = null;
        newLocList = new ArrayList<>();
        
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
//    @Test
//    public void testCreatePet() {
//        assertNotNull(newLocList);
//        assertNotNull(newPet.getUser());
//        Pet petFromDB = petSL.getPetByPetId(newPet.getPetId());
//        assertEquals(newPet, petFromDB);
//    }

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

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

    List<Loc> locList;
    List<User> userList;
    List<Pet> petList;

    Loc loc;
    User user;
    Pet pet;

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

        //createLoc
        loc = DaoTestHelper.createLoc(0);
        locSL.createLoc(loc);
        locList = new ArrayList<>();
        locList.add(loc);

        //createUser
        user = DaoTestHelper.createUser(1);
        userSL.createUser(user);

        myNewPet = DaoTestHelper.createPet(1);

    }

    @After
    public void tearDown() {

    }

    /**
     * Test of createPet method, of class PetSL.
     */
    @Test
    public void testCreatePet() {
//        Pet petFromService = petSL.getPetByPetId(myNewPet.getPetId());
//        assertNotNull(petFromService.getUser());
//        assertNotNull(petFromService.getLoc());
//
//        assertEquals(myNewPet, petFromService);
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

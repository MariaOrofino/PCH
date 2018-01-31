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

/**
 *
 * @author n0263892
 */
public class PetSLTest {

    private UserSL userSL;
    private LocSL locSL;
    private PetSL petSL;

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

    }

    @After
    public void tearDown() {

    }

    /**
     * Test of createPet method, of class PetSL.
     */
    @Test
    public void testCreatePet() {

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

    public class PetSLImpl implements PetSL {

        public Pet createPet(Pet petId) {
            return null;
        }

        public void updatePet(Pet pet) {
        }

        public void deletePet(int petId) {
        }

        public Pet getPetByPetId(int petId) {
            return null;
        }

        public List<Pet> getPetbyuserId(int userId) {
            return null;
        }

        public List<Pet> getPetByLocId(int locId) {
            return null;
        }

        public List<Pet> getAllPets() {
            return null;
        }
    }

}

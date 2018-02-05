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
 * @author n0147313
 */
public class UserSLImplTest {

    UserSL userSL;
    PetSL petSL;
    LocSL locSL;
    List<User> userList = new ArrayList<>();
    List<Loc> locList = new ArrayList<>();
    List<Pet> petList = new ArrayList<>();

    User newUser;

    public UserSLImplTest() {
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

        newUser = DaoTestHelper.createUser(1);

        userSL.createUser(newUser);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createUser method, of class UserSLImpl.
     */
    @Test
    public void testCreateUser() {
        assertNotNull(newUser);

    }

    /**
     * Test of retrieveUserById method, of class UserSLImpl.
     */
    @Test
    public void testRetrieveUserById() {
        User fromDao = userSL.retrieveUserById(newUser.getUserId());
        assertEquals(newUser, fromDao);

    }

    /**
     * Test of retrieveAllUsers method, of class UserSLImpl.
     */
    @Test
    public void testRetrieveAllUsers() {

    }

    /**
     * Test of editUser method, of class UserSLImpl.
     */
    @Test
    public void testEditUser() {

    }

    /**
     * Test of deleteUser method, of class UserSLImpl.
     */
    @Test
    public void testDeleteUser() {

    }

    /**
     * Test of retrieveUsersByCityState method, of class UserSLImpl.
     */
    @Test
    public void testRetrieveUsersByCityState() {

    }

    /**
     * Test of retrieveUsersByZip method, of class UserSLImpl.
     */
    @Test
    public void testRetrieveUsersByZip() {

    }

    /**
     * Test of retrieveUsersByPet method, of class UserSLImpl.
     */
    @Test
    public void testRetrieveUsersByPet() {
        List<User> newUserList = userSL.retrieveAllUsers();
        for (User currentUser : newUserList) {
            userSL.deleteUser(currentUser.getUserId());
        }

        List< Pet> newPetList = petSL.getAllPets();
        for (Pet currentPet : newPetList) {
            petSL.deletePet(currentPet.getPetId());
        }
        Pet newPet = DaoTestHelper.createPet(1);
        
        List<Loc> newLocList = new ArrayList<>();
        for (Loc currentLoc : newPet.getLoc()) {
            locSL.createLoc(currentLoc);
            newLocList.add(currentLoc);
        }
        List<User> newUsers = new ArrayList<>();
        for (User currentUser : newPet.getUser()) {
            userSL.createUser(currentUser);
            newUsers.add(currentUser);
        }
        newPet.setLoc(null);
        newPet.setLoc(newLocList);
        newPet.setUser(null);
        newPet.setUser(newUsers);
        petSL.createPet(newPet);
        locSL.retrieveLocsByPet(newPet.getPetId());

        assertNotNull(newPet.getUser());
        assertNotNull(newPet.getLoc());

        List<User> petListNew = userSL.retrieveUsersByPet(newPet.getPetId());
        assertNotNull(petListNew);
        assertEquals(5, petListNew.size());

    }

}

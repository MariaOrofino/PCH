
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.helper.DaoTestHelper;
import com.mycompany.petcomehome.model.Loc;
import com.mycompany.petcomehome.model.Pet;
import com.mycompany.petcomehome.model.User;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author n0263892
 */
public class PetDaoTest {

    Pet newPet;
    User newUser;
    Loc newLoc;
    List<Pet> petList;
    List<User> userList;
    List<Loc> locList;

    @Inject
    PetDao petDao;
    UserDao userDao;
    LocDao locDao;

    public PetDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        petDao = ctx.getBean("petDao", PetDao.class);
        userDao = ctx.getBean("userDao", UserDao.class);
        locDao = ctx.getBean("locDao", LocDao.class);

        petList = petDao.getAllpets();
        userList = userDao.retrieveAllUsers();
        locList = locDao.retrieveAllLocs();

        for (Pet currentPet : petList) {
            petDao.deletePetById(currentPet.getPetId());
        }

        for (User currentUser : userList) {
            userDao.deleteUser(currentUser.getUserId());
        }
        for (Loc currentLoc : locList) {
            locDao.deleteLoc(currentLoc.getLocId());
        }

        newPet = DaoTestHelper.createPet(1);

        for (User currentUser : newPet.getUser()) {
            userDao.createUser(currentUser);
        }

        for (Loc currentLoc : newPet.getLoc()) {
            locDao.createLoc(currentLoc);
        }

        petDao.createPet(newPet);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createPet method, of class PetDaoDBImpl.
     */
    @Test
    public void testCreatePet() {
        newPet.setPetType(null);
        newPet.setPetStatus(null);
        newPet.setLoc(null);
        newPet.setUser(null);
        Pet fromDao = petDao.getPetByPetId(newPet.getPetId());
        assertNotNull(fromDao);
        assertEquals(fromDao, newPet);

    }

    /**
     * Test of updatePet method, of class PetDaoDBImpl.
     */
    @Test
    public void testUpdatePet() {

        newPet.setPetName("Louie");
        Pet updatedPet = petDao.updatePet(newPet);
        assertEquals("Louie", updatedPet.getPetName());

    }

    /**
     * Test of deletePetById method, of class PetDaoDBImpl.
     */
    @Test
    public void testDeletePetById() {
        petDao.deletePetById(newPet.getPetId());
        assertNull(petDao.getPetByPetId(newPet.getPetId()));
    }

    /**
     * Test of getPetByPetId method, of class PetDaoDBImpl.
     */
    @Test
    public void testGetPetByPetId() {
        newPet.setPetType(null);
        newPet.setPetStatus(null);
        newPet.setLoc(null);
        newPet.setUser(null);
        Pet fromDao = petDao.getPetByPetId(newPet.getPetId());
        assertEquals(fromDao, newPet);
    }

    /**
     * Test of getAllpets method, of class PetDaoDBImpl.
     */
    @Test
    public void testGetAllpets() {
        newPet.setPetType(null);
        newPet.setPetStatus(null);
        newPet.setLoc(null);
        newPet.setUser(null);
        List<Pet> fromDao = petDao.getAllpets();
        assertEquals(petList.size(), fromDao.size());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.Pet;
import com.mycompany.petcomehome.model.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author n0263892
 */
public class PetDaoDBImplTest {

    Pet newPet = new Pet();
    List<Pet> petList = new ArrayList<>();

    @Inject
    PetDao petDao;

    public PetDaoDBImplTest() {
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

        petList = petDao.getAllpets();
//
//        List<User> users = serDao.getAllusers();
//        for (user currentUser : users) {
//            UserDao.deleteUserById(currentUser.getUserId());
//        }
//        }
//
        List<Pet> pets = petDao.getAllpets();
        for (Pet currentPet : pets) {
            petDao.deletePetById(currentPet.getPetId());
        }

        newPet.setPetId(0);
        newPet.setPetName("Roxy");
        newPet.setPetChipTag("123456");
        newPet.setPetRabbiesTag("78910");
        newPet.setPetDesc("crack lab that is cray");
        newPet.setPetBreed("BlackLab");
        newPet.setPetSize("large");
        newPet.setPetColor("black");
        newPet.setPetImgURL("http://imagesarefun.html");

        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate petDate = LocalDate.parse("2017-01-01", f2);
        newPet.setPetCreateDate(petDate);
        newPet.setPetModifiedDate(petDate);
        newPet.setPetLostDate(petDate);
        newPet.setPetFoundDate(petDate);
        newPet.setPetSightedDate(petDate);

        petDao.createPet(newPet);
        petList = petDao.getAllpets();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setJdbcTemplate method, of class PetDaoDBImpl.
     */
    @Test
    public void testSetJdbcTemplate() {
    }

    /**
     * Test of createPet method, of class PetDaoDBImpl.
     */
    @Test
    public void testCreatePet() {
//        Pet fromDao = petDao.getPetByPetId((newPet.getPetId());

    }

    /**
     * Test of updatePet method, of class PetDaoDBImpl.
     */
    @Test
    public void testUpdatePet() {
    }

    /**
     * Test of savePet method, of class PetDaoDBImpl.
     */
    @Test
    public void testSavePet() {
    }

    /**
     * Test of deletePetById method, of class PetDaoDBImpl.
     */
    @Test
    public void testDeletePetById() {
    }

    /**
     * Test of getPetByPetId method, of class PetDaoDBImpl.
     */
    @Test
    public void testGetPetByPetId() {
    }

    /**
     * Test of getAllpets method, of class PetDaoDBImpl.
     */
    @Test
    public void testGetAllpets() {
    }

}

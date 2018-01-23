
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.Loc;
import com.mycompany.petcomehome.model.Pet;
import com.mycompany.petcomehome.model.PetStatus;
import com.mycompany.petcomehome.model.PetType;
import com.mycompany.petcomehome.model.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.tools.JavaFileManager.Location;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

    Pet newPet = new Pet();
    PetType newPetType = new PetType();
    PetStatus newPetStatus = new PetStatus();
    List<Pet> petList = new ArrayList<>();
    User newUser = new User();
    Loc newLoc = new Loc();

    @Inject
    PetDao petDao;
    PetTypeDao petTypeDao;
    PetStatusDao petStatusDao;
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

        newPetStatus.setPetStatusId(1);
        newPetType.setPetTypeId(1);

        newUser.setUserId(21);
        newLoc.setLocId(1);

        newPet.setPetId(0);
        newPet.setPetName("Roxy");
        newPet.setPetChipTag("123456");
        newPet.setPetRabiesTag("78910");
        newPet.setPetDesc("crack lab that is cray");
        newPet.setPetBreed("BlackLab");
        newPet.setPetSize("large");
        newPet.setPetColor("black");
        newPet.setPetImgURL("http://imagesarefun.html");

        newPet.setPetType(newPetType);
        newPet.setPetStatus(newPetStatus);

        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate petDate = LocalDate.parse("2017-01-01", f2);
        newPet.setPetCreateDate(petDate);
        newPet.setPetModifiedDate(petDate);
        newPet.setPetLostDate(petDate);
        newPet.setPetFoundDate(petDate);
        newPet.setPetSightedDate(petDate);

        petDao.createPet(newPet);

        newPet.setPetType(null);
        newPet.setPetStatus(null);
//
//        newUser.setUserId(null);
//        newLoc.setLoc(null);
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
        Pet fromDao = petDao.getPetByPetId(newPet.getPetId());
        assertNotNull(fromDao);
//        assertEquals("Roxy", newPet.getPetName());
//        assertEquals("123456", newPet.getPetChipTag());
//        assertEquals("78910", newPet.getPetRabbiesTag());
//        assertEquals("crack lab that is cray", newPet.getPetDesc());
//        assertEquals("BlackLab", newPet.getPetBreed());
//        assertEquals("Large", newPet.getPetSize());
//        assertEquals("Black", newPet.getPetColor());
//        assertEquals("http://imagesarefun.html", newPet.getPetImgURL());
//        assertEquals("2017-01-01", newPet.getPetCreateDate());
//        assertEquals("2017-01-01", newPet.getPetModifiedDate());
//        assertEquals("2017-01-01", newPet.getPetLostDate());
//        assertEquals("2017-01-01", newPet.getPetFoundDate());
//        assertEquals("2017-01-01", newPet.getPetSightedDate());

        assertEquals(fromDao, newPet);

    }

    /**
     * Test of updatePet method, of class PetDaoDBImpl.
     */
    @Test
    public void testUpdatePet() {
        newPet.setPetType(newPetType);
        newPet.setPetStatus(newPetStatus);

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
        Pet fromDao = petDao.getPetByPetId(newPet.getPetId());
        assertEquals(fromDao, newPet);
    }

    /**
     * Test of getAllpets method, of class PetDaoDBImpl.
     */
    @Test
    public void testGetAllpets() {
        List<Pet> fromDao = petDao.getAllpets();
        assertEquals(petList, fromDao);
        assertNotNull(fromDao);
    }

}

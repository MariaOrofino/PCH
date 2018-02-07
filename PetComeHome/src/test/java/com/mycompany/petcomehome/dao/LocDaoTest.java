/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.helper.DaoTestHelper;
import com.mycompany.petcomehome.model.Loc;
import com.mycompany.petcomehome.model.Pet;
import java.util.List;
import javax.inject.Inject;
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
 * @author n0135705
 */
public class LocDaoTest {

    Loc newLoc;
    List<Loc> addedLoc;
//    Pet newCreatedPet;

    @Inject
    LocDao locDao;
    PetDao petDao;

    public LocDaoTest() {
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
        locDao = ctx.getBean("locDao", LocDao.class);

        List<Loc> newLocList = locDao.retrieveAllLocs();
        for (Loc currentLoc : newLocList) {
            locDao.deleteLoc(currentLoc.getLocId());
        }

        newLoc = DaoTestHelper.createLoc(1);

        locDao.createLoc(newLoc);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createLoc method, of class LocDao.
     */
    @Test
    public void testCreateLoc() {
        assertNotNull(newLoc);
        Loc fromDao = locDao.retrieveLocByLocId(newLoc.getLocId());
        assertNotNull(fromDao);
        assertEquals(fromDao.getLocId(), newLoc.getLocId());
    }

    /**
     * Test of editLoc method, of class LocDao.
     */
    @Test
    public void testEditLoc() {
        newLoc.setLocName("This is a test of the update");
        locDao.editLoc(newLoc);
        assertEquals("This is a test of the update", newLoc.getLocName());
    }

    /**
     * Test of deleteLoc method, of class LocDao.
     */
    @Test
    public void testDeleteLoc() {
        locDao.deleteLoc(newLoc.getLocId());
        assertNull(locDao.retrieveLocByLocId(newLoc.getLocId()));
    }

    /**
     * Test of retrieveLocByLocId method, of class LocDao.
     */
    @Test
    public void testRetrieveLocByLocId() {
        Loc chosenLoc = locDao.retrieveLocByLocId(newLoc.getLocId());
        assertEquals(locDao.retrieveLocByLocId(newLoc.getLocId()), chosenLoc);
    }

    /**
     * Test of retrieveAllLocs method, of class LocDao.
     */
    @Test
    public void testRetrieveAllLocs() {
        List<Loc> locList = locDao.retrieveAllLocs();
        assertNotNull(locList);
        for (Loc currentLoc : locList) {
            assertEquals("NH", currentLoc.getLocState());
        }
    }

    /**
     * Test of retrieveLocByPets method, of class LocDao.
     */
    @Test
    public void testRetrieveLocsByPet() {
        Pet newCreatedPet = DaoTestHelper.createPet(1);
        List<Loc> locListByPet = locDao.retrieveLocsByPet(newCreatedPet.getPetId());
        assertNotNull(locListByPet);
    }
}

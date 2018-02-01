/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.service;

import com.mycompany.petcomehome.helper.DaoTestHelper;
import com.mycompany.petcomehome.model.Loc;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author n0000991
 */
public class LocServiceImplTest {

    LocSL locSL;
    Loc newLoc;
    List<Loc> locList;

    public LocServiceImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

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
        newLoc = DaoTestHelper.createLoc(1);
        locSL.createLoc(newLoc);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createLoc method, of class LocServiceImpl.
     */
    @Test
    public void testCreateLoc() {
        Loc locFromDB = locSL.retrieveLocByLocId(newLoc.getLocId());
        assertEquals(newLoc, locFromDB);
    }

    /**
     * Test of editLoc method, of class LocServiceImpl.
     */
    @Test
    public void testEditLoc() {
    }

    /**
     * Test of deleteLoc method, of class LocServiceImpl.
     */
    @Test
    public void testDeleteLoc() {
        assertEquals(1, locSL.retrieveAllLocs().size());
    }

    /**
     * Test of retrieveLocByLocId method, of class LocServiceImpl.
     */
    @Test
    public void testRetrieveLocByLocId() {
    }

    /**
     * Test of retrieveAllLocs method, of class LocServiceImpl.
     */
    @Test
    public void testRetrieveAllLocs() {
    }

    /**
     * Test of retrieveLocsByPet method, of class LocServiceImpl.
     */
    @Test
    public void testRetrieveLocsByPet() {
    }

}
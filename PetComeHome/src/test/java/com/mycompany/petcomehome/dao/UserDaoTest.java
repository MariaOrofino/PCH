/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.User;
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
 * @author n0147313
 */
public class UserDaoTest {

    @Inject
    private UserDao userDao;

    public UserDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        userDao = ctx.getBean("userDao", UserDao.class);

        User user = new User();

        user.setUserLogin("Jan");
        user.setUserPassword("gentille");
        user.setUserFirstName("Colin");
        user.setUserLastName("Principe");
        user.setUserCity("fremont");
        user.setUserState("NH");
        user.setUserZip("03822");
        user.setUserMobile("6031234567");
        user.setUserAltPhone("60345678901");
        user.setUserEmail("johndoe@libertymutusal.com");
        user.setUserAltEmail("janedoe@libertymutusal.com");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createUser method, of class UserDao.
     */
    @Test
    public void testCreateUser() {

    }

    /**
     * Test of retrieveUserById method, of class UserDao.
     */
    @Test
    public void testRetrieveUserById() {

    }

    /**
     * Test of retrieveAllUsers method, of class UserDao.
     */
    @Test
    public void testRetrieveAllUsers() {

    }

    /**
     * Test of editUser method, of class UserDao.
     */
    @Test
    public void testEditUser() {

    }

    /**
     * Test of deleteUser method, of class UserDao.
     */
    @Test
    public void testDeleteUser() {

    }

    /**
     * Test of retrieveUsersByCityState method, of class UserDao.
     */
    @Test
    public void testRetrieveUsersByCityState() {

    }

    /**
     * Test of retrieveUsersByZip method, of class UserDao.
     */
    @Test
    public void testRetrieveUsersByZip() {

    }

}

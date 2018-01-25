/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.User;
import java.util.ArrayList;
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
 * @author n0147313
 */
public class UserDaoTest {

    User newUser = new User();
    List<User> userList;

    @Inject
    UserDao userDao;

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

        List<User> users = userDao.retrieveAllUsers();
        for (User currentUser : users) {
            userDao.deleteUser(currentUser.getUserId());
        }

        newUser.setUserId(1);
        newUser.setUserLogin("Jan");
        newUser.setUserPassword("Gentille");
        newUser.setUserFirstName("Colin");
        newUser.setUserLastName("Principe");
        newUser.setUserCity("Fremont");
        newUser.setUserState("NH");
        newUser.setUserZip("03822");
        newUser.setUserMobile("6031234567");
        newUser.setUserAltPhone("6034567890");
        newUser.setUserEmail("johndoe@libertymutusal.com");
        newUser.setUserAltEmail("janedoe@libertymutusal.com");

        userDao.createUser(newUser);

//        List<User> userList = userDao.retrieveAllUsers();

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createUser method, of class UserDao.
     */
    @Test
    public void testCreateUser() {
        User fromDao = userDao.retrieveUserById(newUser.getUserId());
        assertNotNull(fromDao);
        assertEquals("NH", fromDao.getUserState());
        assertEquals(fromDao, newUser);

    }

    /**
     * Test of retrieveUserById method, of class UserDao.
     */
    @Test
    public void testRetrieveUserById() {
        User fromDao = userDao.retrieveUserById(newUser.getUserId());
        assertEquals(fromDao, newUser);
    }

    /**
     * Test of retrieveAllUsers method, of class UserDao.
     */
    @Test
    public void testRetrieveAllUsers() {
        List<User> fromDao = userDao.retrieveAllUsers();
//        assertEquals(userList, fromDao);
        assertNotNull(fromDao);
    }

    /**
     * Test of editUser method, of class UserDao.
     */
    @Test
    public void testEditUser() {
        newUser.setUserFirstName("Al");
        userDao.editUser(newUser);
        assertEquals("Al", newUser.getUserFirstName());
    }

    /**
     * Test of deleteUser method, of class UserDao.
     */
    @Test
    public void testDeleteUser() {
        userDao.deleteUser(newUser.getUserId());
        assertNull(userDao.retrieveUserById(newUser.getUserId()));
    }

    /**
     * Test of retrieveUsersByCityState method, of class UserDao.
     */
    @Test
    public void testRetrieveUsersByCityState() {
        List<User> fromDao = userDao.retrieveUsersByCityState(newUser.getUserCity(), newUser.getUserState());
        assertNotNull(fromDao);
    }

    /**
     * Test of retrieveUsersByZip method, of class UserDao.
     */
    @Test
    public void testRetrieveUsersByZip() {
        List<User> fromDao = userDao.retrieveUsersByZip(newUser.getUserZip());
        assertNotNull(fromDao);
    }
}

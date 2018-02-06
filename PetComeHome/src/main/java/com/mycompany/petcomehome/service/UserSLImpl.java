package com.mycompany.petcomehome.service;


import com.mycompany.petcomehome.dao.*;
import com.mycompany.petcomehome.model.User;

import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author n0219417
 */
public class UserSLImpl implements UserSL {

    PetDao petDao;
    PetTypeDao petTypeDao;
    PetStatusDao petStatusDao;
    LocDao locDao;
    UserDao userDao;

    @Inject
    public UserSLImpl(PetDao petDao, PetTypeDao petTypeDao, PetStatusDao petStatusDao, UserDao userDao, LocDao locDao) {
        this.petDao = petDao;
        this.petTypeDao = petTypeDao;
        this.petStatusDao = petStatusDao;
        this.userDao = userDao;
        this.locDao = locDao;
    }

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User retrieveUserById(int userId) {
        return userDao.retrieveUserById(userId);
    }

    @Override
    public List<User> retrieveAllUsers() {
        return userDao.retrieveAllUsers();
    }

    @Override
    public User editUser(User user) {
        return userDao.editUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public List<User> retrieveUsersByCityState(String city, String state) {
        return userDao.retrieveUsersByCityState(city, state);
    }

    @Override
    public List<User> retrieveUsersByZip(String zip) {
        return userDao.retrieveUsersByZip(zip);
    }

}
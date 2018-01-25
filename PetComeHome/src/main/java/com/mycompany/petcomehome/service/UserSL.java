package com.mycompany.petcomehome.service;

import com.mycompany.petcomehome.model.User;

import java.util.List;

/**
 *
 * @author n0219417
 */
public interface UserSL {

    User createUser(User user);

    User retrieveUserById(int userId);

    List<User> retrieveAllUsers();

    User editUser(User user);

    void deleteUser(int userId);

    List<User> retrieveUsersByCityState(String city, String state);

    List<User> retrieveUsersByZip(String zip);

    List<User> retrieveUsersByPet(int petId);

}

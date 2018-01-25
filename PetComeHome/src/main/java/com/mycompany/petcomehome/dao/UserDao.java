/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.User;
import java.util.List;

/**
 *
 * @author n0147313
 */
public interface UserDao {

    public User createUser(User user);

    public User retrieveUserById(int userId);

    public List<User> retrieveAllUsers();

    public User editUser(User user);

    public void deleteUser(int userId);

    public List<User> retrieveUsersByCityState(String city, String state);

    public List<User> retrieveUsersByZip(String zip);

    List<User> retrieveUsersByPet(int petId);

}

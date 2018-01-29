/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.service;

import com.mycompany.petcomehome.dao.LocDao;
import com.mycompany.petcomehome.dao.PetDao;
import com.mycompany.petcomehome.dao.PetStatusDao;
import com.mycompany.petcomehome.dao.PetTypeDao;
import com.mycompany.petcomehome.dao.UserDao;
import com.mycompany.petcomehome.model.Loc;
import com.mycompany.petcomehome.model.Pet;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author n0263892
 */
public class PetSLImpl implements PetSL {

    PetDao petDao;
    PetStatusDao petStatusDao;
    PetTypeDao petTypeDao;
    UserDao userDao;
    LocDao locDao;

//
//    private JdbcTemplate jdbcTemplate;
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
    @Inject
    public PetSLImpl(PetDao petDao, PetTypeDao petTypeDao, PetStatusDao petStatusDao, UserDao userDao, LocDao locDao) {
        this.petDao = petDao;
        this.petTypeDao = petTypeDao;
        this.petStatusDao = petStatusDao;
        this.userDao = userDao;
        this.locDao = locDao;

    }
    @Inject
    UserSL userSL;
    LocSL locSL;

    @Override
    public Pet createPet(Pet pet) {
        return petDao.createPet(pet);
    }

    @Override
    public void updatePet(Pet pet) {
        petDao.updatePet(pet);
    }

    @Override
    public void deletePet(int petId) {
        petDao.deletePetById(petId);
    }

    /////////NOT COMPLETE-----MARIA //////////
    @Override
    public Pet getPetByPetId(int petId) {
        Pet pet = petDao.getPetByPetId(petId);

        pet.setUser(userSL.retrieveUsersByPet(petId));
        pet.setLoc(locSL.retrieveLocsByPet(petId));

        return pet;
    }

    @Override
    public List<Pet> getPetbyuserId(int userId) {
        List<Pet> petList = petDao.getPetsByUserId(userId);
        return associateAllThingsWithPet(petList);

    }

    @Override
    public List<Pet> getPetByLocId(int locId) {
        List<Pet> petList = petDao.getPetsByLocId(locId);
        return associateAllThingsWithPet(petList);
    }

    @Override
    public List<Pet> getAllPets() {
        return petDao.getAllpets();
    }

    private List<Pet> associateAllThingsWithPet(List<Pet> petList) {

        for (Pet currentPet : petList) {
            currentPet.setUser(userSL.retrieveUsersByPet(currentPet.getPetId()));
            currentPet.setLoc(locSL.retrieveLocsByPet(currentPet.getPetId()));

        }
        return petList;
    }

}

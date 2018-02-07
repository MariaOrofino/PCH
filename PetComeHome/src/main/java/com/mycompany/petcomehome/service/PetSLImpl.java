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
import com.mycompany.petcomehome.model.User;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author n0263892
 */
public class PetSLImpl implements PetSL {

    @Inject
    PetDao petDao;
    PetStatusDao petStatusDao;
    PetTypeDao petTypeDao;
    UserDao userDao;
    LocDao locDao;

    public PetSLImpl(PetDao petDao, PetStatusDao petStatusDao, PetTypeDao petTypeDao, UserDao userDao, LocDao locDao) {
        this.petDao = petDao;
        this.petStatusDao = petStatusDao;
        this.petTypeDao = petTypeDao;
        this.userDao = userDao;
        this.locDao = locDao;
    }

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

    @Override
    public Pet retrievePetByPetId(int petId) {
        Pet pet = petDao.retrievePetByPetId(petId);
        List<Loc> petLocList = locDao.retrieveLocsByPet(petId);
        pet.setLoc(petLocList);
        User petUser = userDao.retrieveUsersByPet(petId);
        pet.setUser(petUser);
        return pet;
    }

    @Override
    public List<Pet> retrievePetByUserId(int userId) {
        List<Pet> petList = petDao.retrievePetsByUserId(userId);
        return associateAllThingsWithPet(petList);

    }

    @Override
    public List<Pet> retrievePetByLocId(int locId) {
        List<Pet> petList = petDao.retrievePetsByLocId(locId);
        return associateAllThingsWithPet(petList);
    }

    @Override
    public List<Pet> retrieveAllPets() {
        return petDao.retrieveAllPets();
    }

    private List<Pet> associateAllThingsWithPet(List<Pet> petList) {
        for (Pet currentPet : petList) {
            currentPet.setUser(userDao.retrieveUsersByPet(currentPet.getPetId()));
            currentPet.setLoc(locDao.retrieveLocsByPet(currentPet.getPetId()));
        }
        return petList;
    }
}

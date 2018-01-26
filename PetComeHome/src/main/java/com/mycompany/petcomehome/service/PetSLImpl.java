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
import com.mycompany.petcomehome.model.Pet;
import com.mycompany.petcomehome.model.User;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author n0263892
 */
public class PetSLImpl implements PetSL {

    PetDao petDao;
    PetTypeDao petTypeDao;
    PetStatusDao petStatusDao;
    LocDao locDao;
    UserDao userDao;
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
//        pet.setLoc(locSL.retrieveLocByPet(getPetByLocId(petId)));
        return null;
    }

    @Override
    public List<Pet> getPetbyuserId(int userId) {
        List<Pet> petList = petDao.getPetsByUserId(userId);
        return associateAllObjectsWithPet(petList);

    }

    @Override
    public Pet getPetByLocId(int locId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pet> getAllPets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<Pet> associateAllObjectsWithPet(List<Pet> petList) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        for (Pet currentPet : petList) {
            currentPet.setUser(userSL.retrieveUsersByPet(currentPet.getPetId()));
//            currentPet.setLoc(LocSL.retrieveLocsByPet(currentPet.getPetId()));

        }
        return petList;
    }

}

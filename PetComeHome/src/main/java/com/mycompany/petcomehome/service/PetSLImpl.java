/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.service;

import com.mycompany.petcomehome.dao.PetDao;
import com.mycompany.petcomehome.dao.PetStatusDao;
import com.mycompany.petcomehome.dao.PetTypeDao;
import com.mycompany.petcomehome.model.Pet;
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
//

//    private JdbcTemplate jdbcTemplate;
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
    @Inject
    public PetSLImpl(PetDao petDao, PetTypeDao petTypeDao, PetStatusDao petStatusDao) {
        this.petDao = petDao;
        this.petTypeDao = petTypeDao;
        this.petStatusDao = petStatusDao;
    }

    @Override
    public Pet createPet(Pet pet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pet updatePet(Pet pet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pet deletePet(Pet pet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pet getPetByPetId(int petId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pet getPetbyuserId(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pet getPetByLocId(int locId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pet> getAllPets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.Dao;

import com.mycompany.petcomehome.model.Pet;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maria, Cindy, Denise
 */
public class PetDaoDBImpl implements PetDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private static final String SQL_INSERT_PET
            = "insert into Pet (petName, petChipTag, petRabiesTag, petDescripton, petBreed, petSize, petColor, petImgUrl, petCreateDate, petModifiedDate, petLostDate, petFoundDate, petSightedDate) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_PET_BY_ID
            = "update pet "
            + "set petName=?, petChipTag=?, petRabiesTag=?, petDescripton=?, petBreed=?, petSize=?, petColor=?, petImgUrl=?, petCreateDate=?, petModifiedDate=?, petLostDate=?, petFoundDate=?, petSightedDate=? "
            + "where petId =?";

    private static final String SQL_DELETE_PET
            = "delete from pet where petId = ?";

    @Override
    public Pet createPet(Pet pet) {
        jdbcTemplate.update(SQL_INSERT_PET,
                pet.getPetName(),
                pet.getPetChipTag(),
                pet.getPetRabbiesTag(),
                pet.getPetDesc(),
                pet.getPetBreed(),
                pet.getPetSize(),
                pet.getPetColor(),
                pet.getPetImgURL(),
                pet.getPetCreateDate(),
                pet.getPetModifiedDate(),
                pet.getPetLostDate(),
                pet.getPetFoundDate(),
                pet.getPetSightedDate());
        int petId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);

        pet.setPetId(petId);
        return pet;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updatePet(Pet pet) {
        jdbcTemplate.update(SQL_UPDATE_PET_BY_ID,
                pet.getPetName(),
                pet.getPetChipTag(),
                pet.getPetRabbiesTag(),
                pet.getPetDesc(),
                pet.getPetBreed(),
                pet.getPetSize(),
                pet.getPetColor(),
                pet.getPetImgURL(),
                pet.getPetCreateDate(),
                pet.getPetModifiedDate(),
                pet.getPetLostDate(),
                pet.getPetFoundDate(),
                pet.getPetSightedDate());

        jdbcTemplate.update(SQL_DELETE_USER_HAS_PET, pet.getPetId());
        jdbcTemplate.update(SQL_DELETE_PET_HAS_LOCATION, pet.getPetId());
    }

    @Override
    public void savePet(Pet pet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePetById(int petId) {
        jdbcTemplate.update(SQL_DELETE_PET, petId);
    }

    @Override
    public Pet getPetByPetId(int petId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pet> getAllpets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

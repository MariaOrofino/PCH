/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.Loc;
import com.mycompany.petcomehome.model.Pet;
import com.mycompany.petcomehome.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
            = "insert into Pet (petName, petChipTag, petRabiesTag, petDesc, petBreed, petSize, petColor, petImgUrl, petType_petTypeId, petCreateDate, petModifiedDate, petLostDate, petFoundDate, petSightedDate, petStatus_petStatusId) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_PET_BY_ID
            = "update pet "
            + "set petName=?, petChipTag=?, petRabiesTag=?, petDesc=?, petBreed=?, petSize=?, petColor=?, petImgUrl=?, petType_petTypeId=?, petCreateDate=?, petModifiedDate=?, petLostDate=?, petFoundDate=?, petSightedDate=?, petStatus_petStatusId=? "
            + "where petId =?";

    private static final String SQL_DELETE_PET
            = "delete from pet where petId = ?";

    private static final String SQL_DELETE_PET_HAS_USER
            = "delete from pet_has_user where pet_petId = ?";

    private static final String SQL_DELETE_PET_HAS_LOCATION
            = "delete from pet_has_location where pet_petId = ?";

    private static final String SQL_INSERT_PET_HAS_USER
            = "insert into Pet_has_User (Pet_petId, User_userId) "
            + "values (?, ?)";

    private static final String SQL_INSERT_PET_HAS_LOCATION
            = "insert into pet_has_location (Pet_petId, Location_locId) "
            + "values (?, ?)";

    private static final String SQL_SELECT_PET_BY_ID
            = "select * from  pet "
            + "where petId = ?";
    private static final String SQL_SELECT_ALL_PETS
            = "select * from pet ";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Pet createPet(Pet pet) {
        jdbcTemplate.update(SQL_INSERT_PET,
                pet.getPetName(),
                pet.getPetChipTag(),
                pet.getPetRabiesTag(),
                pet.getPetDesc(),
                pet.getPetBreed(),
                pet.getPetSize(),
                pet.getPetColor(),
                pet.getPetImgURL(),
                pet.getPetType().getPetTypeId(),
                pet.getPetCreateDate().toString(),
                pet.getPetModifiedDate().toString(),
                pet.getPetLostDate().toString(),
                pet.getPetFoundDate().toString(),
                pet.getPetSightedDate().toString(),
                pet.getPetStatus().getPetStatusId());
        int petId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);

        pet.setPetId(petId);
        insertPetHasUser(pet);
        insertPetHasLocation(pet);

        return pet;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Pet updatePet(Pet pet) {
        jdbcTemplate.update(SQL_UPDATE_PET_BY_ID,
                pet.getPetName(),
                pet.getPetChipTag(),
                pet.getPetRabiesTag(),
                pet.getPetDesc(),
                pet.getPetBreed(),
                pet.getPetSize(),
                pet.getPetColor(),
                pet.getPetImgURL(),
                pet.getPetType().getPetTypeId(),
                pet.getPetCreateDate().toString(),
                pet.getPetModifiedDate().toString(),
                pet.getPetLostDate().toString(),
                pet.getPetFoundDate().toString(),
                pet.getPetSightedDate().toString(),
                pet.getPetStatus().getPetStatusId(),
                pet.getPetId());

        jdbcTemplate.update(SQL_DELETE_PET_HAS_USER, pet.getPetId());
        jdbcTemplate.update(SQL_DELETE_PET_HAS_LOCATION, pet.getPetId());
        insertPetHasUser(pet);
        insertPetHasLocation(pet);
        return pet;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deletePetById(int petId) {
        jdbcTemplate.update(SQL_DELETE_PET_HAS_USER, petId);
        jdbcTemplate.update(SQL_DELETE_PET_HAS_LOCATION, petId);

        jdbcTemplate.update(SQL_DELETE_PET, petId);

    }

    @Override
    public Pet getPetByPetId(int petId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PET_BY_ID,
                    new petMapper(), petId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Pet> getAllpets() {
        List<Pet> petList = jdbcTemplate.query(SQL_SELECT_ALL_PETS,
                new petMapper());
        return petList;

    }

    @Override
    public List<Pet> getPetsByUserId(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pet> getPetsByLocId(int locId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pet> getPetsByTypeId(int typeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <List> Pet getPetByColor(String color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <List> Pet getPetBySize(String size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <List> Pet getPetByBreed(String breed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <List> Pet getPetByChipTag(String chipTag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <List> Pet getPetByRabiesTag(String rabiesTag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <List> Pet getPetByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void insertPetHasUser(Pet pet) {
        final List<User> userList = pet.getUser();
        for (User currentUser : userList) {
            jdbcTemplate.update(SQL_INSERT_PET_HAS_USER, pet.getPetId(), currentUser.getUserId());

        }
    }

    private void insertPetHasLocation(Pet pet) {
        final List<Loc> locList = pet.getLoc();
        for (Loc currentLoc : locList) {
            jdbcTemplate.update(SQL_INSERT_PET_HAS_LOCATION, pet.getPetId(), currentLoc.getLocId());

        }
    }

    private static final class petMapper implements RowMapper<Pet> {

        @Override
        public Pet mapRow(ResultSet rs, int i) throws SQLException {
            Pet petMap = new Pet();

            petMap.setPetId(rs.getInt("petId"));
            petMap.setPetName(rs.getString("petName"));
            petMap.setPetChipTag(rs.getString("petChipTag"));
            petMap.setPetRabiesTag(rs.getString("petRabiesTag"));
            petMap.setPetDesc(rs.getString("petDesc"));
            petMap.setPetBreed(rs.getString("petBreed"));
            petMap.setPetSize(rs.getString("petSize"));
            petMap.setPetColor(rs.getString("petColor"));
            petMap.setPetImgURL(rs.getString("petImgUrl"));
            petMap.setPetRabiesTag(rs.getString("petRabiesTag"));
            petMap.setPetCreateDate(rs.getDate("petCreateDate").toLocalDate());
            petMap.setPetModifiedDate(rs.getDate("petModifiedDate").toLocalDate());
            petMap.setPetLostDate(rs.getDate("petLostDate").toLocalDate());
            petMap.setPetFoundDate(rs.getDate("petFoundDate").toLocalDate());
            petMap.setPetSightedDate(rs.getDate("petSightedDate").toLocalDate());

            return petMap;

        }
    }
}

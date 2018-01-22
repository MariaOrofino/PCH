/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.Dao;

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
            = "insert into Pet (petName, petChipTag, petRabiesTag, petDescripton, petBreed, petSize, petColor, petImgUrl, petCreateDate, petModifiedDate, petLostDate, petFoundDate, petSightedDate) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_PET_BY_ID
            = "update pet "
            + "set petName=?, petChipTag=?, petRabiesTag=?, petDescripton=?, petBreed=?, petSize=?, petColor=?, petImgUrl=?, petCreateDate=?, petModifiedDate=?, petLostDate=?, petFoundDate=?, petSightedDate=? "
            + "where petId =?";

    private static final String SQL_DELETE_PET
            = "delete from pet where petId = ?";

    private static final String SQL_DELETE_USER_HAS_PET
            = "delete from pet where petId = ?";

    private static final String SQL_DELETE_PET_HAS_LOCATION
            = "delete from pet where petId = ?";

    private static final String SQL_INSERT_USER_HAS_PET
            = "insert into user_hasPet (user_userId, pet_petId) "
            + "values (?, ?)";

    private static final String SQL_INSERT_PET_HAS_LOCATION
            = "insert into pet_has_location (pet_petId, location_locationId) "
            + "values (?, ?)";

    private static final String SQL_SELECT_PET_BY_ID
            = "insert into pet_has_location (pet_petId, location_locationId) "
            + "where petId =?";
    private static final String SQL_SELECT_ALL_PETS
            = "select * from pet ";

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

    private void insertUserHasPet(Pet pet) {
        final List<User> userList = pet.getUser();
        for (User currentUser : userList) {
            jdbcTemplate.update(SQL_INSERT_USER_HAS_PET, pet.getPetId(), currentUser.getUserId());

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
            petMap.setPetRabbiesTag(rs.getString("petRabbiesTag"));
            petMap.setPetDesc(rs.getString("petDesc"));
            petMap.setPetBreed(rs.getString("petBreed"));
            petMap.setPetSize(rs.getString("petSize"));
            petMap.setPetColor(rs.getString("petColor"));
            petMap.setPetImgURL(rs.getString("petImgUrl"));
            petMap.setPetRabbiesTag(rs.getString("petRabbiesTag"));
            petMap.setPetCreateDate(rs.getDate("petCreateDate").toLocalDate());
            petMap.setPetModifiedDate(rs.getDate("petModifiedDate").toLocalDate());
            petMap.setPetLostDate(rs.getDate("petLostDate").toLocalDate());
            petMap.setPetFoundDate(rs.getDate("petFoundDate").toLocalDate());
            petMap.setPetSightedDate(rs.getDate("petSightedDate").toLocalDate());

            return petMap;

        }
    }
}

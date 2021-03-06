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
            = "insert into Pet (petName, petChipTag, petRabiesTag, petDesc, petBreed, petSize, petColor, petImgUrl, petType_petTypeId, petCreateDate, petModifiedDate, petLostDate, petFoundDate, petSightedDate, petStatus_petStatusId, user_userid) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_PET_BY_ID
            = "update pet "
            + "set petName=?, petChipTag=?, petRabiesTag=?, petDesc=?, petBreed=?, petSize=?, petColor=?, petImgUrl=?, petType_petTypeId=?, petCreateDate=?, petModifiedDate=?, petLostDate=?, petFoundDate=?, petSightedDate=?, petStatus_petStatusId=?, user_userid=? "
            + "where petId =?";

    private static final String SQL_DELETE_PET
            = "delete from pet where petId = ?";

//    private static final String SQL_DELETE_PET_HAS_USER
//            = "delete from pet_has_user where pet_petId = ?";
    private static final String SQL_DELETE_PET_HAS_LOCATION
            = "delete from pet_has_location where pet_petId = ?";

//    private static final String SQL_INSERT_PET_HAS_USER
//            = "insert into Pet_has_User (Pet_petId, User_userId) "
//            + "values (?, ?)";
    private static final String SQL_INSERT_PET_HAS_LOCATION
            = "insert into pet_has_location (Pet_petId, Location_locId) "
            + "values (?, ?)";

    private static final String SQL_SELECT_PET_BY_ID
            = "select * from  pet "
            + "where petId = ?";

    private static final String SQL_SELECT_ALL_PETS
            = "select p.petId, p.petName, p.petChipTag, p.petRabiesTag, p.petDesc, p.petBreed, p.petSize, "
            + "p.petColor, p.petImgUrl, p.PetType_petTypeId, p.petCreateDate, p.petModifiedDate, "
            + "p.petLostDate, p.petFoundDate, p.petSightedDate, p.petStatus_petStatusId "
            + "from pet p";

    private static final String SQL_SELECT_PETS_BY_USER_ID
            = "select p.petId, p.petName, p.petChipTag, p.petRabiesTag, p.petDesc, p.petBreed, p.petSize, "
            + "p.petColor, p.petImgUrl, p.PetType_petTypeId, p.petCreateDate, p.petModifiedDate, "
            + "p.petLostDate, p.petFoundDate, p.petSightedDate, p.petStatus_petStatusId "
            + "from pet p join pet_has_user pu on p.petId = pu.Pet_petId "
            + "where pu.User_userId = ?";

    private static final String SQL_SELECT_PETS_BY_LOC_ID
            = "select p.petId, p.petName, p.petChipTag, p.petRabiesTag, p.petDesc, p.petBreed, p.petSize, p.petColor, p.petImgUrl, "
            + "p.PetType_petTypeId, p.petCreateDate, p.petModifiedDate, p.petLostDate, p.petFoundDate, p.petSightedDate, p.petStatus_petStatusId "
            + "from pet p join pet_has_location pl on p.petId = pl.pet_petId "
            + "where pl.Location_locId = ? "
            + "order by pl.location_locid ";

    private static final String SQL_SELECT_PETS_BY_TYPE
            = "select p.petId, p.petName, p.petChipTag, p.petRabiesTag, p.petDesc,"
            + " p.petBreed, p.petSize, p.petColor,"
            + " p.petImgUrl, p.PetType_petTypeId, p.petCreateDate, p.petModifiedDate, p.petLostDate,"
            + " p.petFoundDate, p.petSightedDate, p.petStatus_petStatusId "
            + " from pet p"
            + " join petType pt on pt.petTypeId = p.PetType_petTypeId"
            + " where pt.petTypeId = ?";

    private static final String SQL_SELECT_PET_BY_COLOR
            = "select * from pet "
            + "where petColor = ?";

    private static final String SQL_SELECT_PET_BY_SIZE
            = "select * from pet "
            + "where petSize = ?";

    private static final String SQL_SELECT_PET_BY_BREED
            = "select * from pet "
            + "where petBreed = ?";

    private static final String SQL_SELECT_PET_BY_CHIPTAG
            = "select * from pet "
            + "where petChipTag = ?";

    private static final String SQL_SELECT_PET_BY_RABIESTAG
            = "select * from pet "
            + "where petRabiesTag = ?";

    private static final String SQL_SELECT_PET_BY_PETNAME
            = "select * from pet "
            + "where petName = ?";

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
                pet.getPetTypeId(),
                pet.getPetCreateDate().toString(),
                pet.getPetModifiedDate().toString(),
                pet.getPetLostDate().toString(),
                pet.getPetFoundDate().toString(),
                pet.getPetSightedDate().toString(),
                pet.getPetStatusId(),
                pet.getUser().getUserId());
        int petId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);

        pet.setPetId(petId);
//        insertPetHasUser(pet);
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
                pet.getPetTypeId(),
                pet.getPetCreateDate().toString(),
                pet.getPetModifiedDate().toString(),
                pet.getPetLostDate().toString(),
                pet.getPetFoundDate().toString(),
                pet.getPetSightedDate().toString(),
                pet.getPetStatusId(),
                pet.getUser().getUserId(),
                pet.getPetId());

//        jdbcTemplate.update(SQL_DELETE_PET_HAS_USER, pet.getPetId());
        jdbcTemplate.update(SQL_DELETE_PET_HAS_LOCATION, pet.getPetId());
//        insertPetHasUser(pet);
        insertPetHasLocation(pet);
        return pet;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deletePetById(int petId) {
//        jdbcTemplate.update(SQL_DELETE_PET_HAS_USER, petId);
        jdbcTemplate.update(SQL_DELETE_PET_HAS_LOCATION, petId);
        jdbcTemplate.update(SQL_DELETE_PET, petId);
    }

    @Override
    public Pet retrievePetByPetId(int petId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PET_BY_ID,
                    new petMapper(), petId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Pet> retrieveAllPets() {
        List<Pet> petList = jdbcTemplate.query(SQL_SELECT_ALL_PETS,
                new petMapper());
        return petList;

    }

    @Override
    public List<Pet> retrievePetsByUserId(int userId) {
        try {
            return jdbcTemplate.query(SQL_SELECT_PETS_BY_USER_ID,
                    new petMapper(),
                    userId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Pet> retrievePetsByLocId(int locId) {
        try {
            return jdbcTemplate.query(SQL_SELECT_PETS_BY_LOC_ID,
                    new petMapper(),
                    locId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Pet> retrievePetsByTypeId(int typeId) {
        return jdbcTemplate.query(SQL_SELECT_PETS_BY_TYPE,
                new petMapper(),
                typeId);
    }

    @Override
    public List<Pet> retrievePetByColor(String color) {
        try {
            return jdbcTemplate.query(SQL_SELECT_PET_BY_COLOR,
                    new petMapper(),
                    color);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Pet> retrievePetBySize(String size) {
        return jdbcTemplate.query(SQL_SELECT_PET_BY_SIZE,
                new petMapper(), size);
    }

    @Override
    public List<Pet> retrievePetByBreed(String breed) {
        return jdbcTemplate.query(SQL_SELECT_PET_BY_BREED,
                new petMapper(), breed);
    }

    @Override
    public List<Pet> retrievePetByChipTag(String chipTag) {
        try {
            return jdbcTemplate.query(SQL_SELECT_PET_BY_CHIPTAG,
                    new petMapper(),
                    chipTag);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Pet> retrievePetByRabiesTag(String rabiesTag) {
        try {
            return jdbcTemplate.query(SQL_SELECT_PET_BY_RABIESTAG,
                    new petMapper(),
                    rabiesTag);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Pet> retrievePetByName(String name) {
        try {
            return jdbcTemplate.query(SQL_SELECT_PET_BY_PETNAME,
                    new petMapper(),
                    name);
        } catch (Exception e) {
            return null;
        }
    }

//    private void insertPetHasUser(Pet pet) {
//        final List<User> userList = pet.getUser();
//        for (User currentUser : userList) {
//            jdbcTemplate.update(SQL_INSERT_PET_HAS_USER, pet.getPetId(), currentUser.getUserId());
//
//        }
//    }
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
            petMap.setPetTypeId(rs.getInt("PetType_petTypeId"));
            petMap.setPetCreateDate(rs.getDate("petCreateDate").toLocalDate());
            petMap.setPetModifiedDate(rs.getDate("petModifiedDate").toLocalDate());
            petMap.setPetLostDate(rs.getDate("petLostDate").toLocalDate());
            petMap.setPetFoundDate(rs.getDate("petFoundDate").toLocalDate());
            petMap.setPetSightedDate(rs.getDate("petSightedDate").toLocalDate());
            petMap.setPetStatusId(rs.getInt("PetStatus_petStatusId"));

            return petMap;

        }
    }
}

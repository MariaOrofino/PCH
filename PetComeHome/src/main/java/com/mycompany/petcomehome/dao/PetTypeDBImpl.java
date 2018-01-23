/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.PetType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author n0263892
 */
public class PetTypeDBImpl implements PetTypeDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private static final String SQL_INSERT_PETTYPE
            = "insert into petType (petType) "
            + "values (?)";

    private static final String SQL_UPDATE_PETTYPE_BY_ID
            = "update petType "
            + "set petType=? "
            + "where petTypeId =?";

    private static final String SQL_DELETE_PETTYPE
            = "delete from petType where petTypeId = ?";

    private static final String SQL_SELECT_ALL_PETTYPEES
            = "select * from petType ";

    private static final String SQL_SELECT_PETTYPE_BY_ID
            = "select * from petType "
            + "where petTypeId =?";

    @Override
    public PetType createPettype(PetType petType) {
        jdbcTemplate.update(SQL_INSERT_PETTYPE,
                petType.getPetTypeId());

        int petTypeId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);

        petType.setPetTypeId(petTypeId);

        return petType;
    }

    @Override
    public PetType updatePetType(PetType petType) {
        jdbcTemplate.update(SQL_UPDATE_PETTYPE_BY_ID,
                petType.getPetTypeId());
        return petType;
    }

    @Override
    public void deletePetType(int petTypeId) {
        jdbcTemplate.update(SQL_DELETE_PETTYPE, petTypeId);
    }

    @Override
    public PetType getPetTypeById(int petTypeId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PETTYPE_BY_ID,
                    new petTypeMapper(), petTypeId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PetType> getAllPetTypes() {
        List<PetType> petStatusList = jdbcTemplate.query(SQL_SELECT_ALL_PETTYPEES,
                new petTypeMapper());
        return petStatusList;
    }

    private static final class petTypeMapper implements RowMapper<PetType> {

        @Override
        public PetType mapRow(ResultSet rs, int i) throws SQLException {
            PetType petTypeMap = new PetType();

            petTypeMap.setPetTypeId(rs.getInt("petTypeId"));
            petTypeMap.setPetSpec(rs.getString("petSpec"));

            return petTypeMap;

        }
    }
}

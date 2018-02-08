/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.Pet;
import com.mycompany.petcomehome.model.PetStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author n0263892
 */
public class PetStatusDBImpl implements PetStatusDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private static final String SQL_INSERT_PETSTATUS
            = "insert into petStatus (petStatus) "
            + "values (?)";

    private static final String SQL_UPDATE_PETSTATUS_BY_ID
            = "update petStatus "
            + "set petStatus=? "
            + "where petStatusId =?";

    private static final String SQL_DELETE_PETSTATUS
            = "delete from petStatus where petStatusId = ?";

    private static final String SQL_SELECT_ALL_PETSTATUSES
            = "select * from petStatus ";

    private static final String SQL_SELECT_PETSTATUS_BY_ID
            = "select * from petStatus "
            + "where petStatusId =?";

    @Override
    public PetStatus createPetStatus(PetStatus petStatus) {
        jdbcTemplate.update(SQL_INSERT_PETSTATUS,
                petStatus.getPetStatus());

        int petStatusId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);

        petStatus.setPetStatusId(petStatusId);

        return petStatus;
    }

    @Override
    public PetStatus updatePetStatus(PetStatus petStatus) {
        jdbcTemplate.update(SQL_UPDATE_PETSTATUS_BY_ID,
                petStatus.getPetStatus());
        return petStatus;
    }

    @Override
    public void deletePetStatus(int petStatusId) {
        jdbcTemplate.update(SQL_DELETE_PETSTATUS, petStatusId);
    }

    @Override
    public PetStatus getPetStatusById(int petStatusId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PETSTATUS_BY_ID,
                    new petStatusMapper(), petStatusId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PetStatus> getAllPetStatus() {
        List<PetStatus> petStatusList = jdbcTemplate.query(SQL_SELECT_ALL_PETSTATUSES,
                new petStatusMapper());
        return petStatusList;
    }

    private static final class petStatusMapper implements RowMapper<PetStatus> {

        @Override
        public PetStatus mapRow(ResultSet rs, int i) throws SQLException {
            PetStatus petStatusMap = new PetStatus();

            petStatusMap.setPetStatusId(rs.getInt("petStatusId"));
            petStatusMap.setPetStatus(rs.getString("petStatus"));

            return petStatusMap;

        }
    }
}

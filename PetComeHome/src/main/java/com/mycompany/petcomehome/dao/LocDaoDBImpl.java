/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.Loc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author n0135705
 */
public class LocDaoDBImpl implements LocDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_LOC
            = "insert into location (locName, locDesc, locCity, locState, "
            + "locZip, locInd, locLat, locLong) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_EDIT_LOC
            = "update location set locName = ?, locDesc = ?,  "
            + "locCity = ?, locState = ?, locZip = ?, locInd = ?, "
            + "locLat = ?, locLong = ? where locId = ?";

    private static final String SQL_DELETE_LOC
            = "delete from location where locId = ?";

    private static final String SQL_RETRIEVE_ONE_LOC
            = "select * from location where locId = ?";

    private static final String SQL_RETRIEVE_ALL_LOCS
            = "select * from location order by locId";

    private static final String SQL_DELETE_PET_HAS_LOC
            = "delete from pet_has_location where location_locid = ?";

    private static final String SQL_RETRIEVE_PETS_BY_LOC
            = "select l.locName, l.locDesc,  l.locCity, l.locState, "
            + "l.locZip, l.locInd, l.locLat, l.locLong "
            + "from location l "
            + "join pet_has_location phl "
            + "on l.locid = phl.location_locid "
            + "where l.locid = ? "
            + "order by l.locid";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Loc createLoc(Loc loc) {
        jdbcTemplate.update(SQL_INSERT_LOC,
                loc.getLocName(),
                loc.getLocDesc(),
                loc.getLocCity(),
                loc.getLocState(),
                loc.getLocZip(),
                loc.getLocInd(),
                loc.getLocLat(),
                loc.getLocLong());
        loc.setLocId(
                jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class));
        return loc;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Loc editLoc(Loc loc) {
        jdbcTemplate.update(SQL_EDIT_LOC,
                loc.getLocId(),
                loc.getLocName(),
                loc.getLocDesc(),
                loc.getLocCity(),
                loc.getLocState(),
                loc.getLocZip(),
                loc.getLocInd(),
                loc.getLocLat(),
                loc.getLocLong());

        return loc;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteLoc(int locId) {
        jdbcTemplate.update(SQL_DELETE_PET_HAS_LOC, locId);
        jdbcTemplate.update(SQL_DELETE_LOC, locId);
    }

    @Override
    public Loc retrieveLocByLocId(int locId) {
        try {
            return jdbcTemplate.queryForObject(SQL_RETRIEVE_ONE_LOC,
                    new LocMapper(), locId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Loc> retrieveAllLocs() {
        List<Loc> locList = jdbcTemplate.query(SQL_RETRIEVE_ALL_LOCS,
                new LocMapper());
        return locList;
    }

    @Override
    public List<Loc> retrievePetsByLoc(int locId) {
        List<Loc> petLocList = jdbcTemplate.query(SQL_RETRIEVE_PETS_BY_LOC,
                new LocMapper(), locId);
        return petLocList;
    }

    private static final class LocMapper implements RowMapper<Loc> {

        @Override
        public Loc mapRow(ResultSet rs, int rowNum) throws SQLException {
            Loc loc = new Loc();
            loc.setLocId(rs.getInt("locId"));
            loc.setLocName(rs.getString("locName"));
            loc.setLocDesc(rs.getString("locDesc"));
            loc.setLocCity(rs.getString("locCity"));
            loc.setLocState(rs.getString("locState"));
            loc.setLocZip(rs.getString("locZip"));
            loc.setLocInd(rs.getString("locInd"));
            loc.setLocLat(rs.getDouble("locLat"));
            loc.setLocLong(rs.getDouble("locLong"));

            return loc;
        }
    }

}

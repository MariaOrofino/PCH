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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author n0135705
 */
public class LocDaoDBImpl implements LocDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    //SQL statements needed
    
    @Override
    public Loc createLoc(Loc loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Loc editLoc(Loc loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLoc(int locId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Loc retrieveLocByLocId(int locId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Loc> retrieveAllLocs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Loc> retrieveLocByPets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class LocMapper implements RowMapper<Loc> {

        @Override
        public Loc mapRow(ResultSet rs, int rowNum) throws SQLException {
            Loc loc = new Loc();
            loc.setLocId(rs.getInt("locId"));
            loc.setLocName(rs.getString("locName"));
            loc.setLocDesc(rs.getString("locDesc"));
            loc.setLocAddress(rs.getString("locAddress"));
            loc.setLocCity(rs.getString("locCity"));
            loc.setLocState("locState");
            loc.setLocZip(rs.getString("locZip"));
            loc.setLocInd(rs.getString("locInd"));
            loc.setLocLat(rs.getBigDecimal("locLat"));
            loc.setLocLong(rs.getBigDecimal("locLong"));

            return loc;
        }
    }
    
}

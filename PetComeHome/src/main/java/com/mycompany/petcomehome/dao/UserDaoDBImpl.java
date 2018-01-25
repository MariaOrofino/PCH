/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.User;
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
 * @author n0147313
 */

public class UserDaoDBImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_USER
            = "insert into user (userLogin, userPassword, userFirstName, userLastName, userCity, userState, "
            + "userZip, userMobile, userAltPhone, userEmail, userAltEmail) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_RETRIEVE_ONE_USER
            = "select * from user where userId = ?";

    private static final String SQL_RETRIEVE_ALL_USERS
            = "select * from user";
    
    private static final String SQL_EDIT_USER
            = "update user set userLogin = ?, userPassword = ?, userFirstName = ?, "
            + "userLastName = ?, userCity = ?, userState = ?, "
            + "userZip = ?, userMobile = ?, userAltPhone = ?, userEmail = ?, userAltEmail = ? "
            + "where userId = ?";
    
    private static final String SQL_DELETE_USER
            = "delete from user where userId = ?";
    
    private static final String SQL_RETRIEVE_USERS_BY_CITYSTATE
            = " select * from user where usercity = ? and userstate = ?";

    private static final String SQL_RETRIEVE_USERS_BY_ZIP
            = "select * from user where userzip = ?";

    private static final String SQL_RETRIEVE_USERS_BY_PET
            = "select * from user join user_has_pet p on userId = p.User_userId "
            + "where p.Pet_petId = ?";

    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User createUser(User user) {
        jdbcTemplate.update(SQL_INSERT_USER,
                user.getUserLogin(),
                user.getUserPassword(),
                user.getUserFirstName(),
                user.getUserLastName(),
                user.getUserCity(),
                user.getUserState(),
                user.getUserZip(),
                user.getUserMobile(),
                user.getUserAltPhone(),
                user.getUserEmail(),
                user.getUserAltEmail());
        user.setUserId(
                jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class));
        return user;
    }

    @Override
    public User retrieveUserById(int userId) {
        try {
            return jdbcTemplate.queryForObject(SQL_RETRIEVE_ONE_USER,
                    new UserMapper(),
                    userId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }


    public List<User> retrieveUsersByPet(int petId) {
        try {
            return jdbcTemplate.query(SQL_RETRIEVE_USERS_BY_PET,
                    new UserMapper(),
                    petId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }



    @Override
    public List<User> retrieveAllUsers() {
        List<User> userList = jdbcTemplate.query(SQL_RETRIEVE_ALL_USERS,
                new UserMapper());
        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User editUser(User user) {
        jdbcTemplate.update(SQL_EDIT_USER,
                user.getUserId(),
                user.getUserLogin(),
                user.getUserPassword(),
                user.getUserFirstName(),
                user.getUserLastName(),
                user.getUserCity(),
                user.getUserState(),
                user.getUserZip(),
                user.getUserMobile(),
                user.getUserAltPhone(),
                user.getUserEmail(),
                user.getUserAltEmail());
                
        return user;
        
    }

    @Override
    public void deleteUser(int userId) {
        jdbcTemplate.update(SQL_DELETE_USER, userId);
    }

    @Override
    public List<User> retrieveUsersByCityState(String city, String state) {
        List<User> userList = jdbcTemplate.query(SQL_RETRIEVE_USERS_BY_CITYSTATE, 
                new UserDaoDBImpl.UserMapper(), city, state);
        return userList;
    }

    @Override
    public List<User> retrieveUsersByZip(String zip) {
                List<User> userList = jdbcTemplate.query(SQL_RETRIEVE_USERS_BY_ZIP, 
                new UserDaoDBImpl.UserMapper(), zip);
        return userList;
    }

    private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            user.setUserLogin(rs.getString("userLogin"));
            user.setUserPassword(rs.getString("userPassword"));
            user.setUserFirstName(rs.getString("userFirstName"));
            user.setUserLastName(rs.getString("userLastName"));
            user.setUserCity(rs.getString("userCity"));
            user.setUserState(rs.getString("userState"));
            user.setUserZip(rs.getString("userZip"));
            user.setUserMobile(rs.getString("userMobile"));
            user.setUserAltPhone(rs.getString("userAltPhone"));
            user.setUserEmail(rs.getString("userEmail"));
            user.setUserAltEmail(rs.getString("userAltEmail"));

            return user;
        }
    }
}

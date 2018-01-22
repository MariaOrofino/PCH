/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.model;

import java.util.Objects;

/**
 *
 * @author n0147313
 */
public class User {

    private int userId;
    private String userLogin;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private String userCity;
    private String userState;
    private String userZip;
    private String userMobile;
    private String userAltPhone;
    private String userEmail;
    private String userAltEmail;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserZip() {
        return userZip;
    }

    public void setUserZip(String userZip) {
        this.userZip = userZip;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserAltPhone() {
        return userAltPhone;
    }

    public void setUserAltPhone(String userAltPhone) {
        this.userAltPhone = userAltPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAltEmail() {
        return userAltEmail;
    }

    public void setUserAltEmail(String userAltEmail) {
        this.userAltEmail = userAltEmail;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.userId;
        hash = 71 * hash + Objects.hashCode(this.userLogin);
        hash = 71 * hash + Objects.hashCode(this.userPassword);
        hash = 71 * hash + Objects.hashCode(this.userFirstName);
        hash = 71 * hash + Objects.hashCode(this.userLastName);
        hash = 71 * hash + Objects.hashCode(this.userCity);
        hash = 71 * hash + Objects.hashCode(this.userState);
        hash = 71 * hash + Objects.hashCode(this.userZip);
        hash = 71 * hash + Objects.hashCode(this.userMobile);
        hash = 71 * hash + Objects.hashCode(this.userAltPhone);
        hash = 71 * hash + Objects.hashCode(this.userEmail);
        hash = 71 * hash + Objects.hashCode(this.userAltEmail);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.userLogin, other.userLogin)) {
            return false;
        }
        if (!Objects.equals(this.userPassword, other.userPassword)) {
            return false;
        }
        if (!Objects.equals(this.userFirstName, other.userFirstName)) {
            return false;
        }
        if (!Objects.equals(this.userLastName, other.userLastName)) {
            return false;
        }
        if (!Objects.equals(this.userCity, other.userCity)) {
            return false;
        }
        if (!Objects.equals(this.userState, other.userState)) {
            return false;
        }
        if (!Objects.equals(this.userZip, other.userZip)) {
            return false;
        }
        if (!Objects.equals(this.userMobile, other.userMobile)) {
            return false;
        }
        if (!Objects.equals(this.userAltPhone, other.userAltPhone)) {
            return false;
        }
        if (!Objects.equals(this.userEmail, other.userEmail)) {
            return false;
        }
        if (!Objects.equals(this.userAltEmail, other.userAltEmail)) {
            return false;
        }
        return true;
    }

}

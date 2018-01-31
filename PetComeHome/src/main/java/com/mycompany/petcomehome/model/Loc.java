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
public class Loc {

    private int locId;
    private String locName;
    private String locDesc;
    private String locCity;
    private String locState;
    private String locZip;
    private String locInd;
    private Double locLat;
    private Double locLong;

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getLocDesc() {
        return locDesc;
    }

    public void setLocDesc(String locDesc) {
        this.locDesc = locDesc;
    }

    public String getLocCity() {
        return locCity;
    }

    public void setLocCity(String locCity) {
        this.locCity = locCity;
    }

    public String getLocState() {
        return locState;
    }

    public void setLocState(String locState) {
        this.locState = locState;
    }

    public String getLocZip() {
        return locZip;
    }

    public void setLocZip(String locZip) {
        this.locZip = locZip;
    }

    public String getLocInd() {
        return locInd;
    }

    public void setLocInd(String locInd) {
        this.locInd = locInd;
    }

    public Double getLocLat() {
        return locLat;
    }

    public void setLocLat(Double locLat) {
        this.locLat = locLat;
    }

    public Double getLocLong() {
        return locLong;
    }

    public void setLocLong(Double locLong) {
        this.locLong = locLong;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.locId;
        hash = 13 * hash + Objects.hashCode(this.locName);
        hash = 13 * hash + Objects.hashCode(this.locDesc);
        hash = 13 * hash + Objects.hashCode(this.locCity);
        hash = 13 * hash + Objects.hashCode(this.locState);
        hash = 13 * hash + Objects.hashCode(this.locZip);
        hash = 13 * hash + Objects.hashCode(this.locInd);
        hash = 13 * hash + Objects.hashCode(this.locLat);
        hash = 13 * hash + Objects.hashCode(this.locLong);
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
        final Loc other = (Loc) obj;
        if (this.locId != other.locId) {
            return false;
        }
        if (!Objects.equals(this.locName, other.locName)) {
            return false;
        }
        if (!Objects.equals(this.locDesc, other.locDesc)) {
            return false;
        }
        if (!Objects.equals(this.locCity, other.locCity)) {
            return false;
        }
        if (!Objects.equals(this.locState, other.locState)) {
            return false;
        }
        if (!Objects.equals(this.locZip, other.locZip)) {
            return false;
        }
        if (!Objects.equals(this.locInd, other.locInd)) {
            return false;
        }
        if (!Objects.equals(this.locLat, other.locLat)) {
            return false;
        }
        if (!Objects.equals(this.locLong, other.locLong)) {
            return false;
        }
        return true;
    }

}

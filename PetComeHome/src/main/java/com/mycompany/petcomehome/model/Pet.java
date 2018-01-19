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
public class Pet {

    private int petId;
    private String petName;
    private String petDesc;
    private String petChip;
    private String PetRabbies;
    private String petType;
    private String petSpec;
    private String petColor;
    private String petSize;
    private String petBreed;
    private String petImgURL;
    private User user;
    private Loc loc;

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetDesc() {
        return petDesc;
    }

    public void setPetDesc(String petDesc) {
        this.petDesc = petDesc;
    }

    public String getPetChip() {
        return petChip;
    }

    public void setPetChip(String petChip) {
        this.petChip = petChip;
    }

    public String getPetRabbies() {
        return PetRabbies;
    }

    public void setPetRabbies(String PetRabbies) {
        this.PetRabbies = PetRabbies;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetSpec() {
        return petSpec;
    }

    public void setPetSpec(String petSpec) {
        this.petSpec = petSpec;
    }

    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }

    public String getPetSize() {
        return petSize;
    }

    public void setPetSize(String petSize) {
        this.petSize = petSize;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public String getPetImgURL() {
        return petImgURL;
    }

    public void setPetImgURL(String petImgURL) {
        this.petImgURL = petImgURL;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Loc getLoc() {
        return loc;
    }

    public void setLoc(Loc loc) {
        this.loc = loc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.petId;
        hash = 41 * hash + Objects.hashCode(this.petName);
        hash = 41 * hash + Objects.hashCode(this.petDesc);
        hash = 41 * hash + Objects.hashCode(this.petChip);
        hash = 41 * hash + Objects.hashCode(this.PetRabbies);
        hash = 41 * hash + Objects.hashCode(this.petType);
        hash = 41 * hash + Objects.hashCode(this.petSpec);
        hash = 41 * hash + Objects.hashCode(this.petColor);
        hash = 41 * hash + Objects.hashCode(this.petSize);
        hash = 41 * hash + Objects.hashCode(this.petBreed);
        hash = 41 * hash + Objects.hashCode(this.petImgURL);
        hash = 41 * hash + Objects.hashCode(this.user);
        hash = 41 * hash + Objects.hashCode(this.loc);
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
        final Pet other = (Pet) obj;
        if (this.petId != other.petId) {
            return false;
        }
        if (!Objects.equals(this.petName, other.petName)) {
            return false;
        }
        if (!Objects.equals(this.petDesc, other.petDesc)) {
            return false;
        }
        if (!Objects.equals(this.petChip, other.petChip)) {
            return false;
        }
        if (!Objects.equals(this.PetRabbies, other.PetRabbies)) {
            return false;
        }
        if (!Objects.equals(this.petType, other.petType)) {
            return false;
        }
        if (!Objects.equals(this.petSpec, other.petSpec)) {
            return false;
        }
        if (!Objects.equals(this.petColor, other.petColor)) {
            return false;
        }
        if (!Objects.equals(this.petSize, other.petSize)) {
            return false;
        }
        if (!Objects.equals(this.petBreed, other.petBreed)) {
            return false;
        }
        if (!Objects.equals(this.petImgURL, other.petImgURL)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.loc, other.loc)) {
            return false;
        }
        return true;
    }

   
}

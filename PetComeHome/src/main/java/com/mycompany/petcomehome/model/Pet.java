/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author n0147313
 */
public class Pet {

    private int petId;
    private String petName;
    private String petDesc;
    private String petChipTag;
    private String PetRabiesTag;
    private String petBreed;
    private String petSize;
    private String petColor;
    private String petImgURL;
    private LocalDate petCreateDate;
    private LocalDate petModifiedDate;
    private LocalDate petLostDate;
    private LocalDate petFoundDate;
    private LocalDate petSightedDate;
    private List<User> user;
    private List<Loc> loc;
    private PetStatus petStatus;
    private PetType petType;

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

    public String getPetChipTag() {
        return petChipTag;
    }

    public void setPetChipTag(String petChipTag) {
        this.petChipTag = petChipTag;
    }

    public String getPetRabiesTag() {
        return PetRabiesTag;
    }

    public void setPetRabiesTag(String PetRabiesTag) {
        this.PetRabiesTag = PetRabiesTag;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public String getPetSize() {
        return petSize;
    }

    public void setPetSize(String petSize) {
        this.petSize = petSize;
    }

    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }

    public String getPetImgURL() {
        return petImgURL;
    }

    public void setPetImgURL(String petImgURL) {
        this.petImgURL = petImgURL;
    }

    public LocalDate getPetCreateDate() {
        return petCreateDate;
    }

    public void setPetCreateDate(LocalDate petCreateDate) {
        this.petCreateDate = petCreateDate;
    }

    public LocalDate getPetModifiedDate() {
        return petModifiedDate;
    }

    public void setPetModifiedDate(LocalDate petModifiedDate) {
        this.petModifiedDate = petModifiedDate;
    }

    public LocalDate getPetLostDate() {
        return petLostDate;
    }

    public void setPetLostDate(LocalDate petLostDate) {
        this.petLostDate = petLostDate;
    }

    public LocalDate getPetFoundDate() {
        return petFoundDate;
    }

    public void setPetFoundDate(LocalDate petFoundDate) {
        this.petFoundDate = petFoundDate;
    }

    public LocalDate getPetSightedDate() {
        return petSightedDate;
    }

    public void setPetSightedDate(LocalDate petSightedDate) {
        this.petSightedDate = petSightedDate;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Loc> getLoc() {
        return loc;
    }

    public void setLoc(List<Loc> loc) {
        this.loc = loc;
    }

    public PetStatus getPetStatus() {
        return petStatus;
    }

    public void setPetStatus(PetStatus petStatus) {
        this.petStatus = petStatus;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    @Override
    public int hashCode() {

        int hash = 5;
        hash = 37 * hash + this.petId;
        hash = 37 * hash + Objects.hashCode(this.petName);
        hash = 37 * hash + Objects.hashCode(this.petDesc);
        hash = 37 * hash + Objects.hashCode(this.petChipTag);
        hash = 37 * hash + Objects.hashCode(this.PetRabiesTag);
        hash = 37 * hash + Objects.hashCode(this.petBreed);
        hash = 37 * hash + Objects.hashCode(this.petSize);
        hash = 37 * hash + Objects.hashCode(this.petColor);
        hash = 37 * hash + Objects.hashCode(this.petImgURL);
        hash = 37 * hash + Objects.hashCode(this.petCreateDate);
        hash = 37 * hash + Objects.hashCode(this.petModifiedDate);
        hash = 37 * hash + Objects.hashCode(this.petLostDate);
        hash = 37 * hash + Objects.hashCode(this.petFoundDate);
        hash = 37 * hash + Objects.hashCode(this.petSightedDate);
        hash = 37 * hash + Objects.hashCode(this.user);
        hash = 37 * hash + Objects.hashCode(this.loc);
        hash = 37 * hash + Objects.hashCode(this.petStatus);
        hash = 37 * hash + Objects.hashCode(this.petType);

        hash = 89 * hash + this.petId;
        hash = 89 * hash + Objects.hashCode(this.petName);
        hash = 89 * hash + Objects.hashCode(this.petDesc);
        hash = 89 * hash + Objects.hashCode(this.petChipTag);
        hash = 89 * hash + Objects.hashCode(this.PetRabiesTag);
        hash = 89 * hash + Objects.hashCode(this.petBreed);
        hash = 89 * hash + Objects.hashCode(this.petSize);
        hash = 89 * hash + Objects.hashCode(this.petColor);
        hash = 89 * hash + Objects.hashCode(this.petImgURL);
        hash = 89 * hash + Objects.hashCode(this.petCreateDate);
        hash = 89 * hash + Objects.hashCode(this.petModifiedDate);
        hash = 89 * hash + Objects.hashCode(this.petLostDate);
        hash = 89 * hash + Objects.hashCode(this.petFoundDate);
        hash = 89 * hash + Objects.hashCode(this.petSightedDate);
        hash = 89 * hash + Objects.hashCode(this.user);
        hash = 89 * hash + Objects.hashCode(this.loc);
        hash = 89 * hash + Objects.hashCode(this.petStatus);
        hash = 89 * hash + Objects.hashCode(this.petType);

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
        if (!Objects.equals(this.petChipTag, other.petChipTag)) {
            return false;
        }
        if (!Objects.equals(this.PetRabiesTag, other.PetRabiesTag)) {
            return false;
        }
        if (!Objects.equals(this.petBreed, other.petBreed)) {
            return false;
        }
        if (!Objects.equals(this.petSize, other.petSize)) {
            return false;
        }
        if (!Objects.equals(this.petColor, other.petColor)) {
            return false;
        }
        if (!Objects.equals(this.petImgURL, other.petImgURL)) {
            return false;
        }
        if (!Objects.equals(this.petCreateDate, other.petCreateDate)) {
            return false;
        }
        if (!Objects.equals(this.petModifiedDate, other.petModifiedDate)) {
            return false;
        }
        if (!Objects.equals(this.petLostDate, other.petLostDate)) {
            return false;
        }
        if (!Objects.equals(this.petFoundDate, other.petFoundDate)) {
            return false;
        }
        if (!Objects.equals(this.petSightedDate, other.petSightedDate)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.loc, other.loc)) {
            return false;
        }
        if (!Objects.equals(this.petStatus, other.petStatus)) {
            return false;
        }
        if (!Objects.equals(this.petType, other.petType)) {
            return false;
        }
        return true;
    }

}

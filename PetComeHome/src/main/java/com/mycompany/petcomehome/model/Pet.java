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
    private User user;
    private List<Loc> loc;
    private int petStatusId;
    private int petTypeId;
//    private PetStatus petStatus;
//    private PetType petType;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Loc> getLoc() {
        return loc;
    }

    public void setLoc(List<Loc> loc) {
        this.loc = loc;
    }

    public int getPetStatusId() {
        return petStatusId;
    }

    public void setPetStatusId(int petStatusId) {
        this.petStatusId = petStatusId;
    }

    public int getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(int petTypeId) {
        this.petTypeId = petTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.petId;
        hash = 59 * hash + Objects.hashCode(this.petName);
        hash = 59 * hash + Objects.hashCode(this.petDesc);
        hash = 59 * hash + Objects.hashCode(this.petChipTag);
        hash = 59 * hash + Objects.hashCode(this.PetRabiesTag);
        hash = 59 * hash + Objects.hashCode(this.petBreed);
        hash = 59 * hash + Objects.hashCode(this.petSize);
        hash = 59 * hash + Objects.hashCode(this.petColor);
        hash = 59 * hash + Objects.hashCode(this.petImgURL);
        hash = 59 * hash + Objects.hashCode(this.petCreateDate);
        hash = 59 * hash + Objects.hashCode(this.petModifiedDate);
        hash = 59 * hash + Objects.hashCode(this.petLostDate);
        hash = 59 * hash + Objects.hashCode(this.petFoundDate);
        hash = 59 * hash + Objects.hashCode(this.petSightedDate);
        hash = 59 * hash + Objects.hashCode(this.user);
        hash = 59 * hash + Objects.hashCode(this.loc);
        hash = 59 * hash + this.petStatusId;
        hash = 59 * hash + this.petTypeId;
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
        if (this.petStatusId != other.petStatusId) {
            return false;
        }
        if (this.petTypeId != other.petTypeId) {
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
        return true;
    }

    
}
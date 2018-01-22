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
public class PetStatus {
    
    private int petStatusId;
    private String petStatus;

    public int getPetStatusId() {
        return petStatusId;
    }

    public void setPetStatusId(int petStatusId) {
        this.petStatusId = petStatusId;
    }

    public String getPetStatus() {
        return petStatus;
    }

    public void setPetStatus(String petStatus) {
        this.petStatus = petStatus;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.petStatusId;
        hash = 89 * hash + Objects.hashCode(this.petStatus);
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
        final PetStatus other = (PetStatus) obj;
        if (this.petStatusId != other.petStatusId) {
            return false;
        }
        if (!Objects.equals(this.petStatus, other.petStatus)) {
            return false;
        }
        return true;
    }
    
    
    
}

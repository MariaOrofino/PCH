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
public class PetType {
    
    private int petTypeId;
    private String petSpec;
    private String other;

    public int getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(int petTypeId) {
        this.petTypeId = petTypeId;
    }

    public String getPetSpec() {
        return petSpec;
    }

    public void setPetSpec(String petSpec) {
        this.petSpec = petSpec;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.petTypeId;
        hash = 89 * hash + Objects.hashCode(this.petSpec);
        hash = 89 * hash + Objects.hashCode(this.other);
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
        final PetType other = (PetType) obj;
        if (this.petTypeId != other.petTypeId) {
            return false;
        }
        if (!Objects.equals(this.petSpec, other.petSpec)) {
            return false;
        }
        if (!Objects.equals(this.other, other.other)) {
            return false;
        }
        return true;
    }
    
    
    
}

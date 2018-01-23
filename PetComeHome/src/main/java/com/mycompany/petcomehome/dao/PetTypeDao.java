/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.PetType;
import java.util.List;

/**
 *
 * @author n0263892
 */
public interface PetTypeDao {

    public PetType createPettype(PetType petType);

    public PetType updatePetType(PetType petType);

    public void deletePetType(int petTypeId);

    public PetType getPetTypeById(int petTypeId);

    public List<PetType> getAllPetTypes();

}

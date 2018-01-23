/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.Pet;
import java.util.List;

/**
 *
 * @author Maria, Cindy, Denise
 */
public interface PetDao {

    public Pet createPet(Pet pet);

    public void updatePet(Pet pet);

    public void deletePetById(int petId);

    public Pet getPetByPetId(int petId);

    public List<Pet> getAllpets();

}

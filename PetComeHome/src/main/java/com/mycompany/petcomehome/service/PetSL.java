/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.service;

import com.mycompany.petcomehome.model.Pet;
import java.util.List;

/**
 *
 * @author n0263892
 */
public interface PetSL {

    public Pet createPet(Pet petId);

    public void updatePet(Pet pet);

    public void deletePet(int petId);

    public Pet retrievePetByPetId(int petId);

    public List<Pet> retrievePetByUserId(int userId);

    public List<Pet> retrievePetByLocId(int locId);

    public List<Pet> retrieveAllPets();

}

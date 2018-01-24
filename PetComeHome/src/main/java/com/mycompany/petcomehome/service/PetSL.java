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

    public Pet createPet(Pet pet);

    public Pet updatePet(Pet pet);

    public Pet deletePet(Pet pet);

    public Pet getPetByPetId(int petId);

    public Pet getPetbyuserId(int userId);

    public Pet getPetByLocId(int locId);

    public List<Pet> getAllPets();

}

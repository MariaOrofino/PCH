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

    public Pet updatePet(Pet pet);

    public void deletePetById(int petId);

    public Pet retrievePetByPetId(int petId);

    public List<Pet> retrieveAllPets();

    public List<Pet> retrievePetsByUserId(int userId);

    public List<Pet> retrievePetsByLocId(int locId);

    public List<Pet> retrievePetsByTypeId(int typeId);

    public List<Pet> retrievePetByColor(String color);

    public List<Pet> retrievePetBySize(String size);

    public List<Pet> retrievePetByBreed(String breed);

    public List<Pet> retrievePetByChipTag(String chipTag);

    public List<Pet> retrievePetByRabiesTag(String rabiesTag);

    public List<Pet> retrievePetByName(String name);

}

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

    public Pet getPetByPetId(int petId);

    public List<Pet> getAllpets();

    public List<Pet> getPetsByUserId(int userId);

    public List<Pet> getPetsByLocId(int locId);

    public List<Pet> getPetsByTypeId(int typeId);

    public List<Pet> getPetByColor(String color);

    public List<Pet> getPetBySize(String size);

    public List<Pet> getPetByBreed(String breed);

    public List<Pet> getPetByChipTag(String chipTag);

    public List<Pet> getPetByRabiesTag(String rabiesTag);

    public List<Pet> getPetByName(String name);

}

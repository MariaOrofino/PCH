/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.service;

import com.mycompany.petcomehome.model.Pet;
import com.mycompany.petcomehome.model.PetType;
import com.mycompany.petcomehome.model.PetStatus;

import java.util.List;

/**
 *
 * @author n0263892
 */
public interface PetSL {

    public Pet createPet(Pet pet);

    public void updatePet(Pet pet);

    public void deletePet(int petId);

    public Pet retrievePetByPetId(int petId);

    public List<Pet> retrievePetByUserId(int userId);

    public List<Pet> retrievePetByLocId(int locId);

    public List<Pet> retrieveAllPets();

    public PetType createPetType(PetType petType);

    public void updatePetType(PetType petType);

    public void deletePetType(int PetTypeId);

    public PetType retrievePetTypeByTypeId(int PetTypeId);

    public List<PetType> retrieveAllPetTypes();

    public PetStatus createPetStatus(PetStatus petStatus);

    public void updatePetStatus(PetStatus petStatus);

    public void deletePetStatus(int PetStatusId);

    public PetStatus retrievePetStatusByStatusId(int PetStatusId);

    public List<PetStatus> retrieveAllPetStatuses();

}

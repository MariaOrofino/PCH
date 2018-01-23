/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.PetStatus;
import java.util.List;

/**
 *
 * @author n0263892
 */
public interface PetStatusDao {

    public PetStatus createPettype(PetStatus petStatus);

    public PetStatus updatePetStatus(PetStatus petStatus);

    public void deletePetStatus(int petStatusId);

    public PetStatus getPetStatusById(int petStatusId);

    public List<PetStatus> getAllPetStatuss();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.service;

import com.mycompany.petcomehome.model.Loc;
import java.util.List;

/**
 *
 * @author n0147313
 */
public interface LocSL {

    public Loc createLoc(Loc loc);

    public Loc editLoc(Loc loc);

    public void deleteLoc(int locId);

    public Loc retrieveLocByLocId(int locId);

    public List<Loc> retrieveAllLocs();

    public List<Loc> retrieveLocsByPet(int petId);

}

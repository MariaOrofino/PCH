/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.Loc;
import java.util.List;

/**
 *
 * @author n0135705
 */
public interface LocDao {
   
    public Loc createLoc(Loc loc);
    
    public Loc editLoc(Loc loc);
    
    public void deleteLoc(int locId);
    
    public Loc retrieveLocByLocId(int locId);
    
    public List<Loc> retrieveAllLocs();
        
    public List<Loc> retrievePetsByLoc(int locId);

}

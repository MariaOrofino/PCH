/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.service;

import com.mycompany.petcomehome.dao.LocDao;
import com.mycompany.petcomehome.dao.PetDao;
import com.mycompany.petcomehome.dao.PetStatusDao;
import com.mycompany.petcomehome.dao.PetTypeDao;
import com.mycompany.petcomehome.dao.UserDao;
import com.mycompany.petcomehome.model.Loc;
import java.util.List;
import javax.inject.Inject;

public class LocSLImpl implements LocSL {

    PetDao petDao;
    PetTypeDao petTypeDao;
    PetStatusDao petStatusDao;
    LocDao locDao;
    UserDao userDao;

    @Inject
    public LocSLImpl(PetDao petDao, PetTypeDao petTypeDao, PetStatusDao petStatusDao, UserDao userDao, LocDao locDao) {
        this.petDao = petDao;
        this.petTypeDao = petTypeDao;
        this.petStatusDao = petStatusDao;
        this.userDao = userDao;
        this.locDao = locDao;
    }

    @Override
    public Loc createLoc(Loc loc) {
        return locDao.createLoc(loc);
    }

    @Override
    public Loc editLoc(Loc loc) {
        return locDao.editLoc(loc);
    }

    @Override
    public void deleteLoc(int locId) {
        locDao.deleteLoc(locId);
    }

    @Override
    public Loc retrieveLocByLocId(int locId) {
        return locDao.retrieveLocByLocId(locId);
    }

    @Override
    public List<Loc> retrieveAllLocs() {
        return locDao.retrieveAllLocs();
    }

    @Override
    public List<Loc> retrieveLocsByPet(int petId) {
       return locDao.retrieveLocsByPet(petId);
    }

}

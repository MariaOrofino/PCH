/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.service;

import com.mycompany.petcomehome.dao.LocDao;
import com.mycompany.petcomehome.dao.PetDao;
import com.mycompany.petcomehome.dao.UserDao;
import com.mycompany.petcomehome.model.Loc;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author n0147313
 */
public class LocSlImpl implements LocSL {

    @Inject
    private LocDao locdao;
    private PetDao petdao;
    private UserDao userdao;

    public LocSlImpl(LocDao locdao,
            PetDao petdao,
            UserDao userdao) {
        this.locdao = locdao;
        this.petdao = petdao;
        this.userdao = userdao;

    }

    @Override
    public Loc createLoc(Loc loc) {
        return locdao.createLoc(loc);
    }

    @Override
    public Loc editLoc(Loc loc) {
        return locdao.editLoc(loc);
    }

    @Override
    public void deleteLoc(int locId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Loc retrieveLocByLocId(int locId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Loc> retrieveAllLocs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Loc> retrievePetsByLoc(int locId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

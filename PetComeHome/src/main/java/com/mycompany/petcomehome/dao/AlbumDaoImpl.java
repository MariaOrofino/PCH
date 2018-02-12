/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.petcomehome.dao;

import com.mycompany.petcomehome.model.Picture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ward
 */
public class AlbumDaoImpl implements AlbumDao {
    
    private Map<Integer, Picture> pictureMap = new HashMap<>();
    
    private int pictureCounter = 0;

    @Override
    public Picture addPicture(Picture picture) {
        picture.setPictureId(pictureCounter);
        pictureCounter++;
        pictureMap.put(picture.getPictureId(), picture);
        return picture;
    }

    @Override
    public void deletePicture(int pictureId) {
        pictureMap.remove(pictureId);
    }

    @Override
    public Picture retrievePictureById(int pictureId) {
        return pictureMap.get(pictureId);
    }

    @Override
    public List<Picture> retrieveAllPictures() {
        List<Picture> pictureList = new ArrayList<>(pictureMap.values());
        return pictureList;
    }
}

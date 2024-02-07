package com.labmanager.project.dao.assets;

import com.labmanager.project.entity.assets.Image;

public interface ImageRepository {

    Image save( Image image );

    Image editImage ( Image image );

    Image findImageById ( int theId );



}

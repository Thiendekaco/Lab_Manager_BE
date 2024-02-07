package com.labmanager.project.service.assets;

import com.labmanager.project.entity.assets.Image;

public interface ImageService {

    Image save(Image image );

    Image editImage ( Image image );

    Image findImageById ( int theId );
}

package com.labmanager.project.service.assets;

import com.labmanager.project.dao.assets.ImageRepository;
import com.labmanager.project.entity.assets.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService{

    private ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image editImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image findImageById(int theId) {
        return imageRepository.findImageById(theId);
    }
}

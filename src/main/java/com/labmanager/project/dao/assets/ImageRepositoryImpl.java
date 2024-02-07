package com.labmanager.project.dao.assets;


import com.labmanager.project.entity.assets.Image;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageRepositoryImpl implements ImageRepository{

    private EntityManager entityManager;

    @Autowired
    public ImageRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Image save(Image image) {
         entityManager.persist(image);
         return findImageById(image.getId());
    }

    @Override
    @Transactional
    public Image editImage(Image image) {
        Image image1 = findImageById(image.getId());
        image1.setData(image.getData());
        entityManager.persist(image1);

        return image1;
    }

    @Override
    @Transactional
    public Image findImageById(int theId) {
        return entityManager.find(Image.class, theId);
    }
}

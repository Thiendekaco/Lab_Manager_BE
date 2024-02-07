package com.labmanager.project.dao.post;


import com.labmanager.project.entity.post.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class PostRepositoryImpl implements PostRepository{

    EntityManager entityManager;

    @Autowired
    public PostRepositoryImpl( EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public Post createNewPost(Post post) {
        entityManager.persist(post);
        return post;
    }

    @Override
    @Transactional
    public Post editPost(Post post) {

        if(post == null) return null;

        entityManager.merge(post);

        return post;
    }

    @Override
    @Transactional
    public void deletePostById(int theId) {
        Post post = findPostById(theId);
        if(post != null){
            System.out.println(post + "123123");
            entityManager.remove(post);
        }
    }

    @Override
    public Post findPostById(int theId) {
        return entityManager.find(Post.class, theId);
    }

    @Override
    public List<Post> findPostByName(String name) {

        TypedQuery<Post> query = entityManager.createQuery("FROM Post where title like :titlePost", Post.class);
        query.setParameter("titlePost", "%" + name + "%" );

        try {
            return  query.getResultList();
        }catch (NoResultException e){
            return new ArrayList<Post>();
        }

    }

    @Override
    public List<Post> findPostByAuthor(String email) {
        TypedQuery<Post> query = entityManager.createQuery("FROM Post where member.user.emailUser = :emailAuthor", Post.class);
        query.setParameter("emailAuthor", email );

        try {
            return  query.getResultList();
        }catch (NoResultException e){
            return new ArrayList<Post>();
        }

    }

    @Override
    public List<Post> findPostByLab(String nameLab) {
        TypedQuery<Post> query = entityManager.createQuery("FROM Post where laboratoryDetail.laboratoryGeneral.nameLab = :namelab", Post.class);
        query.setParameter("namelab", nameLab );

        try {
            return  query.getResultList();
        }catch (NoResultException e){
            return new ArrayList<Post>();
        }
    }

    @Override
    public List<Post> findPostByField( String field) {
        TypedQuery<Post> query = entityManager.createQuery("from Post where :field_ = any (field) ", Post.class);
        query.setParameter("field_", field );

        try {
            return  query.getResultList();
        }catch (NoResultException e){
            return new ArrayList<Post>();
        }
    }

    @Override
    public List<Post> findAll() {
        TypedQuery<Post> query = entityManager.createQuery("FROM Post where passed = true ", Post.class);

        try {
            return  query.getResultList();
        }catch (NoResultException e){
            return new ArrayList<Post>();
        }

    }
}

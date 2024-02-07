package com.labmanager.project.dao.post;

import com.labmanager.project.entity.post.Post;

import java.util.List;

public interface PostRepository {

 Post createNewPost(Post post);

 Post editPost(Post post);

 void deletePostById( int theId );

 Post findPostById ( int theId );

 List<Post> findPostByName (String name );

 List<Post> findPostByAuthor ( String email );

 List<Post> findPostByLab ( String nameLab );

 List<Post> findPostByField ( String field );

 List<Post> findAll ();
}

package com.labmanager.project.service.post;

import com.labmanager.project.entity.laboratory.LaboratoryDetail;
import com.labmanager.project.entity.member.Member;
import com.labmanager.project.entity.post.Post;

import java.util.List;

public interface PostService {

    Post createNewPost(Post post, String member, String laboratoryDetail);

    Post editPost(Post post, String author);

    void deletePostByName( String name, String author );


    List<Post> findListPostByName (String name );

    List<Post> findListPostByAuthor ( String email );

    List<Post> findListPostSuccessOfLab ( String nameLab );

    List<Post> findListPostPendingOfLab ( String nameLab );

    List<Post> findPostByField ( String field );

    List<Post> getAllListResearch ();

}

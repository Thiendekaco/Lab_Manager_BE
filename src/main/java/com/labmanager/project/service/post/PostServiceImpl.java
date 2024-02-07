package com.labmanager.project.service.post;

import com.labmanager.project.dao.laboratory.LaboratoryDetailRepository;
import com.labmanager.project.dao.member.MemberRepository;
import com.labmanager.project.dao.post.PostRepository;
import com.labmanager.project.entity.laboratory.LaboratoryDetail;
import com.labmanager.project.entity.member.Member;
import com.labmanager.project.entity.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements  PostService{

    private PostRepository postRepo;

    private MemberRepository memberRepo;

    private LaboratoryDetailRepository laboratoryDetailRepo;

    @Autowired
    public PostServiceImpl(PostRepository postRepo, MemberRepository memberRepo, LaboratoryDetailRepository laboratoryDetailRepo) {
        this.postRepo = postRepo;
        this.memberRepo = memberRepo;
        this.laboratoryDetailRepo = laboratoryDetailRepo;
    }

    @Override
    public Post createNewPost(Post post, String member, String laboratoryDetail) {
        List<Post> postFounded = postRepo.findPostByName(post.getTitle());
        if(postFounded.size() > 0){
            if(Objects.equals(post.getTitle(), postFounded.get(0).getTitle())){
                return  postFounded.get(0);
            }
        }
        Member member1 = memberRepo.findByEmail(member);
        LaboratoryDetail laboratoryDetail1 = laboratoryDetailRepo.findByName(laboratoryDetail);
        if(member1 == null || laboratoryDetail1 == null) return null;
        post.setMember(member1);
        post.setLaboratoryDetail(laboratoryDetail1);

        postRepo.createNewPost(post);

        return post;

    }

    @Override
    public Post editPost(Post post, String author) {
        if(post == null) return null;
        List<Post> posts = findListPostByAuthor(author);
        List<Post> postFilter = posts.stream().filter(post1 -> { return post1.getCreateAt().toString().equals(post.getCreateAt().toString()); }).toList();
        System.out.println(postFilter.size());
        if (postFilter.size() > 0){
            Post currentPost = postFilter.get(0);
            currentPost.setAllFieldPost(post);
            return postRepo.editPost(currentPost);
        }

        return null;

    }

    @Override
    public void deletePostByName( String name, String author ) {
        List<Post> posts = findListPostByAuthor(author);
        List<Post> postFilter = posts.stream().filter(post1 -> { return Objects.equals(post1.getTitle(), name); }).toList();

        if (postFilter.size() > 0){
            System.out.println(postFilter);
            postRepo.deletePostById(postFilter.get(0).getId());
        }
    }



    @Override
    public List<Post> findListPostByName(String name) {
        return postRepo.findPostByName(name);
    }

    @Override
    public List<Post> findListPostByAuthor(String email) {
        return postRepo.findPostByAuthor(email);
    }

    @Override
    public List<Post> findListPostSuccessOfLab(String nameLab) {
        List<Post> postList = postRepo.findPostByLab(nameLab);
        return postList.stream().filter(Post::isPassed).toList();
    }

    @Override
    public List<Post> findListPostPendingOfLab(String nameLab) {
        List<Post> postList = postRepo.findPostByLab(nameLab);
        return postList.stream().filter( post -> {
            return ! post.isPassed();
        }).toList();
    }

    @Override
    public List<Post> findPostByField(String field) {
        return postRepo.findPostByField(field).stream().filter(Post::isPassed).toList();
    }

    @Override
    public List<Post> getAllListResearch() {
        return postRepo.findAll();
    }


}

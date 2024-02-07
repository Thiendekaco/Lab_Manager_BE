package com.labmanager.project.rest.post;


import com.labmanager.project.dto.MemberDTO;
import com.labmanager.project.dto.MemberDTOBase;
import com.labmanager.project.dto.PostDTOAll;
import com.labmanager.project.dto.RoleMemberDTO;
import com.labmanager.project.entity.laboratory.LaboratoryDetail;
import com.labmanager.project.entity.laboratory.LaboratoryGeneral;
import com.labmanager.project.entity.member.Member;
import com.labmanager.project.entity.member.RoleMember;
import com.labmanager.project.entity.post.Post;
import com.labmanager.project.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostRestController {
    private PostService postService;

    @Autowired
    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/researches")
    public ResponseEntity<List<PostDTOAll>> getListResearch (
            @RequestParam(required = false, name = "author") String author
    ){

        if(author != null){
            return getListResearchByAuthor(author);
        }
        return ResponseEntity.ok(postService.getAllListResearch().stream().map(this::convertEntityToDTOPostAll).toList());
    }

    @GetMapping("/laboratories/{laboratory}/researches")
    public ResponseEntity<List<PostDTOAll>> getListResearchOfLab (@PathVariable String laboratory) {
        return ResponseEntity.ok(postService.findListPostSuccessOfLab(laboratory).stream().map(this::convertEntityToDTOPostAll).toList());
    }

    @GetMapping("/laboratories/{laboratory}/researches/pending")
    public ResponseEntity<List<PostDTOAll>> getListResearchPending ( @PathVariable String laboratory ){
        return ResponseEntity.ok(postService.findListPostPendingOfLab(laboratory).stream().map(this::convertEntityToDTOPostAll).toList());
    }

    @GetMapping("/researches/{research}")
    public ResponseEntity<List<PostDTOAll>> getListResearchByName ( @PathVariable String research ){
        return ResponseEntity.ok(postService.findListPostByName(research).stream().map(this::convertEntityToDTOPostAll).toList());
    }


    private ResponseEntity<List<PostDTOAll>> getListResearchByField (String field ){
        return ResponseEntity.ok(postService.findPostByField(field).stream().map(this::convertEntityToDTOPostAll).toList());
    }

    private ResponseEntity<List<PostDTOAll>> getListResearchByAuthor (String author ){
        return ResponseEntity.ok(postService.findListPostByAuthor(author).stream().map(this::convertEntityToDTOPostAll).toList());
    }


    @PutMapping("/researches")
    public ResponseEntity<PostDTOAll> createNewResearch(@RequestBody ParamRequestCreateResearch param){
        if(param.getPost() == null){
            return null;
        }
        postService.createNewPost(param.getPost(), param.getAuthor(), param.getLaboratory());

        return ResponseEntity.ok(
                convertEntityToDTOPostAll(
                        postService.findListPostByName(param.getPost().getTitle()).get(0)
        ));
    }

    @DeleteMapping("/researches")
    public void deleteResearch(@RequestParam("author") String author, @RequestParam("post") String post){
        postService.deletePostByName(post, author);
    }

    @PostMapping("/researches")
    public ResponseEntity<PostDTOAll> editResearch (@RequestBody ParamRequestCreateResearch param ){

        return ResponseEntity.ok(convertEntityToDTOPostAll(postService.editPost(param.getPost(), param.getAuthor())));
    }


    private PostDTOAll convertEntityToDTOPostAll ( Post post ){
        RoleMemberDTO roleMemberDTO = convertEntityToDTORoleLab(post.getLaboratoryDetail());
        MemberDTOBase memberDTOBase = convertEntityToMemberDTOBase(post.getMember());

        return new PostDTOAll(post.getTitle(), post.getContext(), post.isPassed(), post.getField(), post.getSubtitle(), post.getCreateAt(), memberDTOBase, roleMemberDTO,     "http://localhost:8080/api/image/" + post.getLogo().getId());
    }

    private RoleMemberDTO convertEntityToDTORoleLab (LaboratoryDetail laboratoryDetail){
        LaboratoryGeneral laboratoryGeneral = laboratoryDetail.getLaboratoryGeneral();

        return new RoleMemberDTO(
                laboratoryGeneral.getNameLab(),
                laboratoryGeneral.getNameSchool(),
                laboratoryGeneral.getField(),
                laboratoryGeneral.getRanking(),
                "http://localhost:8080/api/image/" + laboratoryGeneral.getLogo().getId()
        );
    }

    private MemberDTOBase  convertEntityToMemberDTOBase (Member member){
        return new MemberDTOBase(member.getName(), member.getUser().getEmail(), member.getUniversity(), member.getAge(), "http://localhost:8080/api/image/" + member.getLogo().getId());
    }

}

class ParamRequestCreateResearch {
    private String author;

    private String laboratory;

    private Post post;

    public ParamRequestCreateResearch(String author, String nameLab, Post post) {
        this.author = author;
        this.laboratory = nameLab;
        this.post = post;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String admin) {
        this.author = admin;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String nameLab) {
        this.laboratory = nameLab;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}

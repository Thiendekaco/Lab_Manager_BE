package com.labmanager.project.entity.post;


import com.labmanager.project.dao.post.PostRepositoryImpl;
import com.labmanager.project.entity.assets.Image;
import com.labmanager.project.entity.laboratory.LaboratoryDetail;
import com.labmanager.project.entity.member.Member;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private int id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logo")
    private Image logo;

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    @Column(name = "title")
    private String title;

    @Column(name = "context")
    private String context;

    @Column(name = "passed")
    private boolean passed;

    @Type(ListArrayType.class)
    @Column(name = "field", columnDefinition = "character varying[]")
    private Set<String> field;


    @Column(name = "subtitle")
    private String subtitle;

    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_member")
    private Member member;

    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_lab")
    private LaboratoryDetail laboratoryDetail;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    public Post() {
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }
    public int getId() {
        return id;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
        this.createAt = LocalDateTime.now();
    }

    public Set<String> getField() {
        return field;
    }

    public void setField(Set<String> field) {
        this.field = field;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LaboratoryDetail getLaboratoryDetail() {
        return laboratoryDetail;
    }

    public void setLaboratoryDetail(LaboratoryDetail laboratoryDetail) {
        this.laboratoryDetail = laboratoryDetail;
    }

    public Post(String title, Image logo, String context, boolean passed, Set<String> field, String subtitle, Member member, LaboratoryDetail laboratoryDetail) {
        this.title = title;
        this.context = context;
        this.passed = passed;
        this.field = field;
        this.subtitle = subtitle;
        this.member = member;
        this.laboratoryDetail = laboratoryDetail;
        this.createAt = LocalDateTime.now();
        this.logo = logo;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", passed=" + passed +
                ", subtitle='" + subtitle + '\'' +
                ", createAt=" + createAt +
                '}';
    }

    public Post setAllFieldPost (Post postEdit){
        if (postEdit == null) {
            return this;
        }
        if (postEdit.getTitle() != null){
            this.title = postEdit.getTitle();
        };
        this.field = postEdit.getField();
        this.context = postEdit.getContext();
        this.subtitle = postEdit.getSubtitle();
        this.logo = postEdit.getLogo();
        return this;
    }


}

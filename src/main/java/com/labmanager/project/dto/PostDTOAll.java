package com.labmanager.project.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class PostDTOAll extends PostDTOBase{

    private MemberDTOBase author ;
    private RoleMemberDTO laboratory;

    public RoleMemberDTO getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(RoleMemberDTO laboratory) {
        this.laboratory = laboratory;
    }


    public PostDTOAll() {
    }

    public PostDTOAll(String title, String context, boolean passed, Set<String> field, String subtitle, LocalDateTime createAt, MemberDTOBase author, RoleMemberDTO laboratory, String logo) {
        super(title, context, passed, field, subtitle, createAt, logo);
        this.author = author;
        this.laboratory = laboratory;
    }

    public MemberDTOBase getAuthor() {
        return author;
    }

    public void setAuthor(MemberDTOBase author) {
        this.author = author;
    }
}

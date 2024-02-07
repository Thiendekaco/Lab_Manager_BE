package com.labmanager.project.dto;

import com.labmanager.project.entity.laboratory.LaboratoryDetail;
import com.labmanager.project.entity.member.Member;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class PostDTOBase {

    private String title;


    public PostDTOBase() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostDTOBase(String title, String context, boolean passed, Set<String> field, String subtitle, LocalDateTime createAt, String logo) {
        this.title = title;
        this.context = context;
        this.passed = passed;
        this.field = field;
        this.subtitle = subtitle;
        this.createAt = createAt;
        this.logo = logo;
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    private String context;
    private boolean passed;
    private Set<String> field;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    private String subtitle;
    private LocalDateTime createAt;

    private String logo;

}

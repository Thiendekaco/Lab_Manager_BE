package com.labmanager.project.dto;

import java.time.LocalDateTime;

public class LabMemberDTO extends MemberDTOBase{

    private LocalDateTime dateJoined;
    private String statusJoined;

    public LocalDateTime getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getStatusJoined() {
        return statusJoined;
    }

    public void setStatusJoined(String statusJoined) {
        this.statusJoined = statusJoined;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LabMemberDTO(String name, String email, String university, int age, String logo, LocalDateTime dateJoined, String statusJoined, String role) {
        super(name, email, university, age, logo);
        this.dateJoined = dateJoined;
        this.statusJoined = statusJoined;
        this.role = role;
    }

    private String role;

}


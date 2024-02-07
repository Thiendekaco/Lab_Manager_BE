package com.labmanager.project.dto;

import java.util.List;

public class LaboratoryDetailDTO {
    private List<LabMemberDTO> members;
    private  List<String> roles;
    private int  numberOfMember;

    public List<LabMemberDTO> getMembers() {
        return members;
    }

    public void setMembers(List<LabMemberDTO> members) {
        this.members = members;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public int getNumberOfMember() {
        return numberOfMember;
    }

    public void setNumberOfMember(int numberOfMember) {
        this.numberOfMember = numberOfMember;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LaboratoryDetailDTO() {
    }

    public LaboratoryDetailDTO(List<LabMemberDTO> members, List<String> roles, int numberOfMember, String description) {
        this.members = members;
        this.roles = roles;
        this.numberOfMember = numberOfMember;
        this.description = description;
    }

    private String description;
}

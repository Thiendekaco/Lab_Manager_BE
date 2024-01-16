package com.labmanager.project.entity.laboratory;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lab_details")
public class LaboratoryDetail {


    @Id
    @Column(name = "id_lab_details")
    private int id;


    @Column(name = "roles")
    private String roles;

    public String getRoles() {
        return roles;
    }

    public LaboratoryDetail() {}

    public LaboratoryDetail(String roles, int numberOfMember, String description) {
        this.roles = roles;
        this.numberOfMember = numberOfMember;
        this.description = description;
    }

    public void setRoles(String roles) {
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

    @Column(name = "number_of_member")
    private int numberOfMember;

    @Column(name = "description")
    private String description;





    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }



}

package com.labmanager.project.dto;

public class MemberDTOBase {

    private String name;
    private String email;
    private String university;
    private int age;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    private String logo;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MemberDTOBase() {
    }

    public String getUniversity() {
        return university;
    }

    public MemberDTOBase(String name, String email, String university, int age, String logo) {
        this.name = name;
        this.email = email;
        this.university = university;
        this.age = age;
        this.logo = logo;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

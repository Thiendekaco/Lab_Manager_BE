package com.labmanager.project.dto;

import java.util.List;

public class LaboratoryDTO {

    private String nameLab;
    private String nameSchool ;

    public String getNameLab() {
        return nameLab;
    }

    public void setNameLab(String nameLab) {
        this.nameLab = nameLab;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    public List<String> getField() {
        return field;
    }

    public void setField(List<String> field) {
        this.field = field;
    }

    public LaboratoryDetailDTO getLaboratoryDetail() {
        return laboratoryDetail;
    }

    public void setLaboratoryDetail(LaboratoryDetailDTO laboratoryDetail) {
        this.laboratoryDetail = laboratoryDetail;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public LaboratoryDTO(String nameLab, String nameSchool, List<String> field, LaboratoryDetailDTO laboratoryDetail, String logo, int ranking, String location, String country) {
        this.nameLab = nameLab;
        this.nameSchool = nameSchool;
        this.field = field;
        this.laboratoryDetail = laboratoryDetail;
        this.logo = logo;
        this.ranking = ranking;
        this.country = country;
        this.location = location;
    }

    private List<String> field ;

    private LaboratoryDetailDTO laboratoryDetail;
    private String logo;
    private int ranking ;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String country;


}

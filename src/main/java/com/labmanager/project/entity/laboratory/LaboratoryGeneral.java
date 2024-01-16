package com.labmanager.project.entity.laboratory;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lab_general")
public class LaboratoryGeneral {

    @Id
    @Column(name = "id_lab_general")
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }



}

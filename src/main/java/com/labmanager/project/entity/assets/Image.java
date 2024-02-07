package com.labmanager.project.entity.assets;


import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data")
    private byte[] data;

    public Image() {
    }

    public byte[] getData() {
        return data;
    }

    public Image(byte[] data) {
        this.data = data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

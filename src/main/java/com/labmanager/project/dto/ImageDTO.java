package com.labmanager.project.dto;

public class ImageDTO {

    private byte[] data ;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public ImageDTO(byte[] data) {
        this.data = data;
    }
}

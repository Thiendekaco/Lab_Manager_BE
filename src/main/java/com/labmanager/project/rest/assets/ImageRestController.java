package com.labmanager.project.rest.assets;

import com.labmanager.project.dto.ImageDTO;
import com.labmanager.project.entity.assets.Image;
import com.labmanager.project.service.assets.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ImageRestController {
    private ImageService imageService;

    @Autowired
    public ImageRestController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImageById(@PathVariable int id){
        Image imageData  = imageService.findImageById(id);

       return ResponseEntity
            .ok()
            .contentType(MediaType.IMAGE_PNG)
            .body(imageData.getData());
    }


    private ImageDTO convertEntityToDTO(Image image){
        return new ImageDTO(image.getData());
    }
}

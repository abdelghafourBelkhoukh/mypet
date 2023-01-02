package com.myproject.mypet.controller;

import com.myproject.mypet.model.Images;
import com.myproject.mypet.service.ImagesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImagesController {

    private final ImagesService imagesService;

    public ImagesController(ImagesService imagesService) {
        this.imagesService = imagesService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteImagesByAnnouncementId(@PathVariable Long id) {
        imagesService.deleteImagesByAnnouncementId(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Images> addImages(@RequestBody Images images) {
        return new ResponseEntity(imagesService.addImages(images), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Images> updateImages(Images images) {
        return new ResponseEntity(imagesService.updateImages(images), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Images> findImagesById(@PathVariable Long id) {
        return new ResponseEntity(imagesService.findImagesById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Images> findAllImages() {
        return new ResponseEntity(imagesService.findAllImages(), HttpStatus.OK);
    }



}

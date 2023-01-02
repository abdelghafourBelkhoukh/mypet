package com.myproject.mypet.service;

import com.myproject.mypet.model.Images;
import com.myproject.mypet.repo.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesService {

    private final ImagesRepository imagesRepository;

    @Autowired
    public ImagesService(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    public void deleteImagesByAnnouncementId(Long id) {
        imagesRepository.deleteAllByImageAnnouncementId(id);
    }

    public Images addImages(Images images) {
        return imagesRepository.save(images);
    }

    public Images updateImages(Images images) {
        return imagesRepository.save(images);
    }

    public void deleteImages(Long id) {
        imagesRepository.deleteById(id);
    }

    public Images findImagesById(Long id) {
        return imagesRepository.findById(id).orElse(null);
    }

    public Images findImagesByAnnouncementId(Long id) {
        return imagesRepository.findAllByImageAnnouncementId(id).get(0);
    }

    public List<Images> findAllImages() {
        return imagesRepository.findAll();
    }
}

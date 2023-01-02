package com.myproject.mypet.controller;

import com.myproject.mypet.model.Animal;
import com.myproject.mypet.model.Announcement;
import com.myproject.mypet.service.AnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Announcement>> getAllAnnouncements() {
        List<Announcement> announcements = announcementService.findAllAnnouncements();
        return new ResponseEntity(announcements, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Announcement> getAnnouncementById(Long id) {
        Announcement announcement = announcementService.findAnnouncementById(id);
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Announcement> addAnnouncement(@RequestBody Announcement announcement) {
        Announcement newAnnouncement = announcementService.addAnnouncement(announcement);
        return new ResponseEntity<>(newAnnouncement, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Announcement> updateAnnouncement(Announcement announcement) {
        Announcement updateAnnouncement = announcementService.updateAnnouncement(announcement);
        return new ResponseEntity<>(updateAnnouncement, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable("id") Long id) {
        announcementService.deleteAnnouncement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.myproject.mypet.service;

import com.myproject.mypet.model.Announcement;
import com.myproject.mypet.repo.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    public Announcement addAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    public List<Announcement> findAllAnnouncements() {
        return announcementRepository.findAll();
    }

    public Announcement findAnnouncementById(Long id) {
        return announcementRepository.findAnnouncementById(id)
                .orElseThrow();
    }

    public Announcement updateAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    public void deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
    }


}

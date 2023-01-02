package com.myproject.mypet.repo;

import com.myproject.mypet.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    Optional<Announcement> findAnnouncementById(Long id);
}

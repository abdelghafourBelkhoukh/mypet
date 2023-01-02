package com.myproject.mypet.repo;

import com.myproject.mypet.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagesRepository extends JpaRepository<Images, Long> {
    List<Images> findAllByImageAnnouncementId(Long id);

    void deleteAllByImageAnnouncementId(Long id);
}

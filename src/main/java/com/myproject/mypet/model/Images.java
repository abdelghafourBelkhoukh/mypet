package com.myproject.mypet.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class Images {

    @Id @GeneratedValue
    private Long id;

    private String image;

    @ManyToOne
    private Announcement imageAnnouncement;

    public Images(Long id, String image) {
        this.id = id;
        this.image = image;
    }

    public Images() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}

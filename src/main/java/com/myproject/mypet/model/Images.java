package com.myproject.mypet.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.mapping.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "image_announcement_id")
@IdClass(ImagesPK.class)
public class Images {

    @Id @GeneratedValue
    private Long id;
    @Id
    @Column(name = "image_announcement_id")
    private long image_announcement_id;

    private String image;

    @ManyToOne
    @JoinColumn(name = "image_announcement_id", insertable = false, updatable = false)
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

    public long getImage_announcement_id() {
        return image_announcement_id;
    }

    public void setImage_announcement_id(long image_announcement_id) {
        this.image_announcement_id = image_announcement_id;
    }

    public Announcement getImageAnnouncement() {
        return imageAnnouncement;
    }

    public void setImageAnnouncement(Announcement imageAnnouncement) {
        this.imageAnnouncement = imageAnnouncement;
    }
}

class ImagesPK implements Serializable {
    private Long id;
    private long image_announcement_id;

    public ImagesPK() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getImage_announcement_id() {
        return image_announcement_id;
    }

    public void setImage_announcement_id(long image_announcement_id) {
        this.image_announcement_id = image_announcement_id;
    }
}
package com.myproject.mypet.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "images")
public class Announcement {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private Integer NDJ;
    private String description;
    private String date;
    @Column(name = "person_id")
    private long person_id;

    @Column(name = "animal_id")
    private long animal_id;

    @OneToOne
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;

    @OneToOne
    @JoinColumn(name = "animal_id", insertable = false, updatable = false)

    private Animal animal;

    @OneToMany(mappedBy = "imageAnnouncement")
    private List<Images> images;


    @OneToMany(mappedBy = "announcement")
    private List<Comment> comments;


}

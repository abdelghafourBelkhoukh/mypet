package com.myproject.mypet.model;


import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.util.List;

@Entity
@Data
public class Announcement {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String NDJ;
    private String description;
    private String date;

    @OneToOne
    private Person person;

    //relation one to one with animal table
    @OneToOne
    private Animal animal;

    @OneToMany(mappedBy = "imageAnnouncement")
    private List<Images> images;



}

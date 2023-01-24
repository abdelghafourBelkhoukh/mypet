package com.myproject.mypet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment {
    @Id @GeneratedValue
    private Long id;
    private String comment;
    private String date;
    private Long person_id;
    private Long announcement_id;

    @ManyToOne
    @JoinColumn(name = "announcement_id", insertable = false, updatable = false)
    private Announcement announcement;

    public void setAnnouncement_id(Long announcement_id) {
        this.announcement_id = announcement_id;
    }

}

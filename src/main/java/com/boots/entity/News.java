package com.boots.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "news")
    private String news;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "changing_date")
    private Date changingDate;

    public News() {
    }

}

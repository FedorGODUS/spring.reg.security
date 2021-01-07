package com.boots.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "changing_date")
    private Date changingDate;

    public Task() {
    }

}

package com.boots.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "report")
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "report")
    private String report;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "changing_date")
    private Date changingDate;

    @Column(name = "project")
    private String project;

    @Column(name = "project_quality")
    private int projectQuality;

    @Column(name = "company_quality")
    private int companyQuality;

    @Column(name = "general_difficulties")
    private String generalDifficulties;

    @Column(name = "difficulties_on_project")
    private String difficultiesOnProject;

    @Column(name = "risk_of_leaving")
    private String riskOfLeaving;

    @Column(name = "report_RM")
    private String reportRM;

    @Column(name = "report_HR")
    private String reportHR;

    @Column(name = "feed_back_from_project")
    private String feedBackFromProject;

    @Column(name = "personal_feedback")
    private String personalFeedback;

    @Column(name = "goals")
    private String goals;

    public Feedback() {
    }
}

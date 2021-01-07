package com.boots.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=2, message = "Не меньше 5 знаков")
    private String username;
    @Size(min=2, message = "Не меньше 5 знаков")
    private String password;
    @Transient
    private String passwordConfirm;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;



    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chief_id")
    private User chief;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "changing_date")
    private Date changingDate;

    @OneToMany(mappedBy = "owner", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> creatorOfComments;

    @OneToMany(mappedBy = "owner", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Feedback> reports;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Feedback> creatorOfReports;

    @OneToMany(mappedBy = "owner", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Task> tasks;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Task> creatorOfTask;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<News> news;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}

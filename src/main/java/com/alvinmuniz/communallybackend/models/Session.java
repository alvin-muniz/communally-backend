package com.alvinmuniz.communallybackend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private long startTime;

    @Column
    private long endTime;

    @JsonIgnore
    @OneToOne(mappedBy = "session")
    private Reflection reflection;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Session() {
    }

    public Session( Date date, long startTime, long endTime, Reflection reflection, User user) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reflection = reflection;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Reflection getReflection() {
        return reflection;
    }

    public void setReflection(Reflection reflection) {
        this.reflection = reflection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return getStartTime() == session.getStartTime() && getEndTime() == session.getEndTime() && Objects.equals(getId(), session.getId()) && Objects.equals(getDate(), session.getDate()) && Objects.equals(getReflection(), session.getReflection()) && Objects.equals(getUser(), session.getUser());
    }

}

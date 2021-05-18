package com.alvinmuniz.communallybackend.models;


import com.alvinmuniz.communallybackend.models.enums.Mood;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
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
    private LocalDate date;

    @Column
    private Duration duration;

    @JsonIgnore
    @OneToOne(mappedBy = "session")
    private Reflection reflection;

    @JsonIgnore
    @Column
    private Mood moodBefore;

    @JsonIgnore
    @Column
    private Mood moodAfter;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Session() {
    }

    public Session( LocalDate date, Duration duration,
                    Reflection reflection, User user) {
        this.date = date;
        this.duration = duration;
        this.reflection = reflection;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
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

    public Mood getMoodBefore() {
        return moodBefore;
    }

    public void setMoodBefore(Mood moodBefore) {
        this.moodBefore = moodBefore;
    }

    public Mood getMoodAfter() {
        return moodAfter;
    }

    public void setMoodAfter(Mood moodAfter) {
        this.moodAfter = moodAfter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(getId(), session.getId()) && Objects.equals(getDate(),
                session.getDate()) && Objects.equals(getDuration(),
                session.getDuration()) && Objects.equals(getReflection(),
                session.getReflection()) && Objects.equals(getUser(), session.getUser());
    }

}

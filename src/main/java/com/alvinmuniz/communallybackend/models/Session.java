package com.alvinmuniz.communallybackend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

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


}

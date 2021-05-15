package com.alvinmuniz.communallybackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="reflections")
public class Reflection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private Session session;

    @Column
    private String entry;

    //One to Many relationship
    @JsonIgnore
    @OneToMany(mappedBy = "reflection")
    private List<Content> contentList;
}

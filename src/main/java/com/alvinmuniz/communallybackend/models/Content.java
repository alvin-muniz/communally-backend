package com.alvinmuniz.communallybackend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="contents")
public class Content {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String author;

    @Column
    private String url;

    @Column
    private String title;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reflection_id")
    private Reflection reflection;


}

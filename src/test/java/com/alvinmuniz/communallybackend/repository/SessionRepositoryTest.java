package com.alvinmuniz.communallybackend.repository;

import com.alvinmuniz.communallybackend.models.Session;
import com.alvinmuniz.communallybackend.models.User;
import com.alvinmuniz.communallybackend.repository.config.RepositoryTestingBase;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class SessionRepositoryTest extends RepositoryTestingBase {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private SessionRepository sessionRepoUnderTest;

    @Autowired
    private UserRepository userRepo;

    private User testUser;

    Session sessionUnderTest;


    @AfterEach
    void tearDown() {
    }

    @Test
    public void loadUniqueSessionByUserIdAndId() {

    }

    @Test
    public void loadAllSessionsByUserId() {

    }

    @Test
    public void updateSessionByIdAndUserId() {

    }

    @Test
    public void deleteSessionByIdAndUserId() {

    }




}

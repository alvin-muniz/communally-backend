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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class SessionRepositoryTest extends RepositoryTestingBase {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private SessionRepository sessionRepoUnderTest;

    private User testUser;

    Session sessionUnderTest;


    @BeforeEach
    void setUp() {
        sessionUnderTest = new Session();
        testUser = new User();
        testEntityManager.persist(testUser);
        assertNotNull(testUser.getId());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void loadUniqueSessionByUserIdAndId() {
        sessionUnderTest.setUser(testUser);
        sessionRepoUnderTest.save(sessionUnderTest);

       assertEquals(sessionRepoUnderTest.findByUserIdAndId(1l, 1L),
               sessionUnderTest);
    }

    @Test
    public void loadAllSessionsByUserId() {
        List<Session> sessionList = new ArrayList<>();
        sessionUnderTest.setUser(testUser);
        sessionRepoUnderTest.save(sessionUnderTest);
        sessionList.add(sessionUnderTest);
        assertEquals(sessionRepoUnderTest.findAllByUserId(1L), sessionList);
    }

    @Test
    public void updateSessionByIdAndUserId() {
        sessionUnderTest.setUser(testUser);
        sessionRepoUnderTest.save(sessionUnderTest);
        Session foundSession = sessionRepoUnderTest.findByUserIdAndId(1L, 1L);
        assertEquals(foundSession.getStartTime(), 0);
        foundSession.setStartTime(109L);
        sessionRepoUnderTest.save(foundSession);
        foundSession = sessionRepoUnderTest.findByUserIdAndId(1L, 1L);
        assertEquals(foundSession.getStartTime(), 109L);
        assertEquals(foundSession.getId(),1L);
    }

    @Test
    public void deleteSessionByIdAndUserId() {
        sessionUnderTest.setUser(testUser);
        sessionRepoUnderTest.save(sessionUnderTest);
        assertEquals(sessionRepoUnderTest.findByUserIdAndId(1L, 1L),
                sessionUnderTest);
        sessionRepoUnderTest.deleteById(1L);
        assertFalse(sessionRepoUnderTest.existsById(1L));
    }




}

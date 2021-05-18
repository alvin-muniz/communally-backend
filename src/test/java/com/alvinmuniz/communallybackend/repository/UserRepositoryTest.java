package com.alvinmuniz.communallybackend.repository;

import com.alvinmuniz.communallybackend.models.User;
import com.alvinmuniz.communallybackend.repository.config.RepositoryTestingBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;



class UserRepositoryTest extends RepositoryTestingBase {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepoUnderTest;

    User testUser;

    @BeforeEach
    void setUp() {
        /*
        * username, password, email, ID
        * */
        testUser = new User();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void saveUserSuccessfully() {
//        assertEquals(userRepoUnderTest.save(testUser),entityManager.find(User.class, 1L));
    }


}

package com.alvinmuniz.communallybackend.repository;

import com.alvinmuniz.communallybackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAddress(String emailAddress);

}

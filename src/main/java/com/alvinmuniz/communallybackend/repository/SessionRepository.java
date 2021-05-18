package com.alvinmuniz.communallybackend.repository;

import com.alvinmuniz.communallybackend.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    Session findByUserIdAndId(Long userId, Long sessionId);

    List<Session> findAllByUserId(Long userId);


}

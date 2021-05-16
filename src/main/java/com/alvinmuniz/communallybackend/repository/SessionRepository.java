package com.alvinmuniz.communallybackend.repository;

import com.alvinmuniz.communallybackend.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

}

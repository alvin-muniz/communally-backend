package com.alvinmuniz.communallybackend.repository;

import com.alvinmuniz.communallybackend.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

}

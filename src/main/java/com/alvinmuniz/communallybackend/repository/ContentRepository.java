package com.alvinmuniz.communallybackend.repository;

import com.alvinmuniz.communallybackend.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    List<Content> findAllByReflectionId(Long reflectionId);
}

package com.alvinmuniz.communallybackend.repository;

import com.alvinmuniz.communallybackend.models.Reflection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReflectionRepository extends JpaRepository<Reflection, Long> {

}

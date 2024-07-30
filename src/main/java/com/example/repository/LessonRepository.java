package com.example.repository;

import com.example.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LessonRepository extends JpaRepository<LessonEntity, Long> {
}

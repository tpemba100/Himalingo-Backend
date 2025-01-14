package com.example.himalingoBackend.repository;

import com.example.himalingoBackend.entity.WordTranslation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordTranslationRepository extends JpaRepository<WordTranslation, Long> {
}

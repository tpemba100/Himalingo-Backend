package com.example.himalingoBackend.repository;

import com.example.himalingoBackend.entity.SentenceTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentenceTranslationRepository extends JpaRepository<SentenceTranslation, Integer> {
}

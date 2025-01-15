package com.example.himalingoBackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sentence_translations")
@Data
public class SentenceTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "english_sentence", nullable = false)
    private String englishSentence;

    @Column(name = "nepali_translation", nullable = false)
    private String nepaliTranslation;

    @Column(name = "pronunciation", nullable = false)
    private String pronunciation;
}

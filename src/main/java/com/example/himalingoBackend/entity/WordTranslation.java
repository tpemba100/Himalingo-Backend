package com.example.himalingoBackend.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "word_translations")
public class WordTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "word", nullable = false)
    private String word;  // English word

    @Column(name = "language", nullable = false)
    private String language;  // Language (Nepali)

    @Column(name = "translation", nullable = false)
    private String translation;  // Nepali translation

    @Column(name = "pronunciation", nullable = false)
    private String pronunciation;  // English pronunciation of Nepali word

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }
}

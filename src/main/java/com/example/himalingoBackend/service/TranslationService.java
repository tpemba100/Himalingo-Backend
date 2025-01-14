package com.example.himalingoBackend.service;

import com.example.himalingoBackend.entity.WordTranslation;
import com.example.himalingoBackend.repository.WordTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslationService {

    @Autowired
    private WordTranslationRepository wordTranslationRepository;

    // Get all Word Translations
    public List<WordTranslation> getAllWordTranslations() {
        return wordTranslationRepository.findAll();
    }

    // Add a Word Translation
    public WordTranslation addWordTranslation(String word, String translation, String pronunciation) {
        WordTranslation wordTranslation = new WordTranslation();
        wordTranslation.setWord(word);  // English word
        wordTranslation.setLanguage("Nepali");  // Language
        wordTranslation.setTranslation(translation);  // Nepali translation
        wordTranslation.setPronunciation(pronunciation);  // English pronunciation of Nepali word
        return wordTranslationRepository.save(wordTranslation);
    }
}

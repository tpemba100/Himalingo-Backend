package com.example.himalingoBackend.service;

import com.example.himalingoBackend.entity.SentenceTranslation;
import com.example.himalingoBackend.entity.WordTranslation;
import com.example.himalingoBackend.entity.NepaliAlphabets;
import com.example.himalingoBackend.repository.SentenceTranslationRepository;
import com.example.himalingoBackend.repository.WordTranslationRepository;
import com.example.himalingoBackend.repository.NepaliAlphabetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslationService {

    @Autowired
    private SentenceTranslationRepository sentenceTranslationRepository;

    @Autowired
    private WordTranslationRepository wordTranslationRepository;

    @Autowired
    private NepaliAlphabetsRepository nepaliAlphabetsRepository;

    // Get all sentence translations
    public List<SentenceTranslation> getAllSentenceTranslations() {
        return sentenceTranslationRepository.findAll();
    }

    // Add Sentence Translation
    public SentenceTranslation addSentenceTranslation(String englishSentence, String nepaliTranslation, String pronunciation) {
        SentenceTranslation sentenceTranslation = new SentenceTranslation();
        sentenceTranslation.setEnglishSentence(englishSentence);
        sentenceTranslation.setPronunciation(pronunciation);
        return sentenceTranslationRepository.save(sentenceTranslation);
    }

    // Get all word translations
    public List<WordTranslation> getAllWordTranslations() {
        return wordTranslationRepository.findAll();
    }

    // Add Word Translation
    public WordTranslation addWordTranslation(String word, String translation, String pronunciation) {
        WordTranslation wordTranslation = new WordTranslation();
        wordTranslation.setWord(word);
        wordTranslation.setTranslation(translation);
        wordTranslation.setPronunciation(pronunciation);
        return wordTranslationRepository.save(wordTranslation);
    }

    // Get all Nepali Alphabets
    public List<NepaliAlphabets> getAllNepaliAlphabets() {
        return nepaliAlphabetsRepository.findAll();
    }

    // Add Nepali Alphabet
    public NepaliAlphabets addNepaliAlphabet(String nepaliCharacter, String translation, String pronunciation) {
        NepaliAlphabets nepaliAlphabets = new NepaliAlphabets();
        nepaliAlphabets.setNepaliCharacter(nepaliCharacter);
        nepaliAlphabets.setTranslation(translation);
        return nepaliAlphabetsRepository.save(nepaliAlphabets);
    }
}

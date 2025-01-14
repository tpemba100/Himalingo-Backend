package com.example.himalingoBackend.controller;

import com.example.himalingoBackend.entity.WordTranslation;
import com.example.himalingoBackend.entity.NepaliAlphabets;
import com.example.himalingoBackend.service.TranslationService;
import com.example.himalingoBackend.service.AlphabetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/translate")
public class TranslationController {

    @Autowired
    private TranslationService translationService;

    @Autowired
    private AlphabetService alphabetService;

    // Get All Word Translations
    @GetMapping("/words")
    public List<WordTranslation> getAllWordTranslations() {
        return translationService.getAllWordTranslations();
    }

    // Get All Nepali Alphabets
    @GetMapping("/alphabets")
    public List<NepaliAlphabets> getAllNepaliAlphabets() {
        return alphabetService.getAllNepaliAlphabets();
    }

    // Add Word Translation
    @PostMapping("/word")
    public WordTranslation addWordTranslation(@RequestParam String word, @RequestParam String translation, @RequestParam String pronunciation) {
        return translationService.addWordTranslation(word, translation, pronunciation);
    }

    // Add Nepali Alphabet
    @PostMapping("/alphabet")
    public NepaliAlphabets addNepaliAlphabet(@RequestParam String nepaliCharacter, @RequestParam String translation, @RequestParam String pronunciation) {
        return alphabetService.addNepaliAlphabet(nepaliCharacter, translation, pronunciation);
    }
}

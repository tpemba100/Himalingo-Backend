package com.example.himalingoBackend.service;

import com.example.himalingoBackend.entity.NepaliAlphabets;
import com.example.himalingoBackend.repository.NepaliAlphabetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlphabetService {

    @Autowired
    private NepaliAlphabetsRepository nepaliAlphabetsRepository;

    // Get all Nepali Alphabets
    public List<NepaliAlphabets> getAllNepaliAlphabets() {
        return nepaliAlphabetsRepository.findAll();  // Return all Nepali alphabets from the database
    }

    // Add a Nepali Alphabet
    public NepaliAlphabets addNepaliAlphabet(String nepaliCharacter, String translation, String pronunciation) {
        NepaliAlphabets nepaliAlphabets = new NepaliAlphabets();
        nepaliAlphabets.setNepaliCharacter(nepaliCharacter);  // Set Nepali character (e.g., 'अ')
        nepaliAlphabets.setLanguage("Nepali");  // Language (Nepali)
        nepaliAlphabets.setTranslation(translation);  // Translation in English
        return nepaliAlphabetsRepository.save(nepaliAlphabets);  // Save it in the database
    }
}

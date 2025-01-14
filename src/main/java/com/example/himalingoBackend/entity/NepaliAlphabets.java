package com.example.himalingoBackend.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "nepali_alphabets")
public class NepaliAlphabets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nepali_character", nullable = false)
    private String nepaliCharacter;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "translation", nullable = false)
    private String translation;


}

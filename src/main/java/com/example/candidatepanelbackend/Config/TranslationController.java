package com.example.candidatepanelbackend.Config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslationController {

    private final MessageSource messageSource;

    @Autowired
    public TranslationController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/translations")
    public ResponseEntity<Map<String, String>> getTranslations(@RequestParam(required = false, defaultValue = "en") String lang) {
        Locale locale = new Locale(lang);
        Map<String, String> translations = new HashMap<>();
        translations.put("greeting", messageSource.getMessage("greeting", null, locale));
        // Add other translations as needed
        return ResponseEntity.ok(translations);
    }
}
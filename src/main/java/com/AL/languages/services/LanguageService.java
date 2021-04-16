package com.AL.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.AL.languages.models.Language;
import com.AL.languages.repositories.LanguageReop;

@Service
public class LanguageService {
	// adding the book repository as a dependency
    private final LanguageReop languageReop;
    
    public LanguageService(LanguageReop languageReop) {
        this.languageReop = languageReop;
    }
    // returns all the books
    public List<Language> allLanguages() {
        return languageReop.findAll();
    }
    // creates a book
    public Language createLanguage(Language l) {
        return languageReop.save(l);
    }
    // retrieves a book
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageReop.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    public Language updateLanguage(Language l) {
    	return languageReop.save(l);
    }
    
    public void deleteLangauge(Long id) {
    	languageReop.deleteById(id);
    }
    
    public Language saveLangaue(Language l) {
    	return languageReop.save(l);
    }
}

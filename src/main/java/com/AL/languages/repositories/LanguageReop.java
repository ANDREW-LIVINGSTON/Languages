package com.AL.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AL.languages.models.Language;

@Repository
public interface LanguageReop extends CrudRepository<Language, Long>{
	// this method retrieves all the books from the database
    List<Language> findAll();
    
    Optional<Language> findById(Long x);
    // this method finds books with descriptions containing the search string
    
    void deleteById(Long id);
    
    Language save(Language book);
}

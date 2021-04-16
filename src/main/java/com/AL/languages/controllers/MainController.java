package com.AL.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AL.languages.services.LanguageService;
import com.AL.languages.models.Language;


@Controller
public class MainController {
	private final LanguageService languageService;
	public MainController(LanguageService languageService) {
        this.languageService = languageService;
    }
	
	
	@RequestMapping("/")
    public String index(Model model) {
		model.addAttribute("newLanguage", new Language()); // binds to form helper in index.jsp
		model.addAttribute("allLanguages", languageService.allLanguages()); // displays all notes 
		return "index.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
    public String createLanguage(@Valid @ModelAttribute("newLanguage") Language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/";
        }
	}
	
	@RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/";
        }
	}
	@RequestMapping("/languages/{id}")
    public String showLanguage(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("language", languageService.findLanguage(id));
    	return "show.jsp";
    }
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLangauge(id);
        return "redirect:/";
    }
}

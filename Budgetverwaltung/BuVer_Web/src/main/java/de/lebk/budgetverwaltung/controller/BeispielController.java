package de.lebk.budgetverwaltung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.lebk.budgetverwaltung.services.BeispielService;

@Controller
public class BeispielController {

	@Autowired
	BeispielService services;
	
	@RequestMapping("/buver")
	public String start(Model model) {
		model.addAttribute("beispielTyp", services.ladeIrgendwas());
		return "beispiel";
	}

}

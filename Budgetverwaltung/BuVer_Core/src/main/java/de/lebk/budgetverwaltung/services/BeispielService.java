package de.lebk.budgetverwaltung.services;

import de.lebk.budgetverwaltung.dao.BeispielDAO;
import de.lebk.budgetverwaltung.to.BeispielTyp;

public class BeispielService {

	/*
	 * In den Services soll saemtliche eigentliche Logik liegen Alles was der
	 * Benutzer von irgendeiner Oberflaeche aus aufrufen koennen soll, muss hier
	 * als seperate Methode definiert sein
	 */

	private BeispielDAO dao;

	public BeispielService() {
		dao = new BeispielDAO();
	}
	
	public BeispielTyp ladeIrgendwas() {
		return dao.ladeY();
	}
	
}

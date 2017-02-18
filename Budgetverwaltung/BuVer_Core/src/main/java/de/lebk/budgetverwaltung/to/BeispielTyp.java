package de.lebk.budgetverwaltung.to;



/**
 * Ein TO (Transfer-Objekt) ist eine Entitaet die zum Austausch von Informationen mit anderen Projekten genutzt wird
 * Einfach Klassen die ihr nur intern verwendet, kommen bitte in das typen-Package
 * 
 * Es ist wichtig, Aenderungen an TOs nur abgestimmt vorzunehmen
 *
 */
public final class BeispielTyp {
private String attribut;

public BeispielTyp(String attribut) {
	this.attribut = attribut;
}

public String getAttribut() {
	return attribut;
}

}

package de.lebk.budgetverwaltung.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import de.lebk.budgetverwaltung.to.BeispielTyp;

public class BeispielDAO {

	/*
	 * Die DAOs sollen fuer jeweils einen Bereich / einen Typ die
	 * Zugriffsfunktionen bereitstellen
	 * 
	 * Entsprechend dann BenutzerDAO, BudgetDAO, usw
	 */

	/*
	 * Durch "Autowiring" wird euch eine Verbindung aus dem DB-Projekt
	 * bereitgestellt Damit koennt ihr wie gewohnt die SQLs ausfuehren
	 */
	@Autowired
	Connection con;

	private PreparedStatement erzeugeNeuenX;
	private PreparedStatement ladeY;
	private PreparedStatement erhoeheZUmEins;

	public BeispielDAO() {
		// try {
		// erzeugeNeuenX = con.prepareStatement("INSERT INTO bla(attribut) VALUES(?);");
		// ladeY = con.prepareStatement("SELECT * FROM bla;");
		// erhoeheZUmEins = con.prepareStatement("UPDATE bla SET cd = cd+1 WHERE ab LIKE ?;");
		// } catch (SQLException e) {
		// Logger.getGlobal().log(Level.SEVERE, "Fehler bei der Initialisierung des DAO", e);
		// }
		//
	}

	public void erzeugeNeuenX(String x) {
		try {
			// So wird ein PreparedStatement mit den konkreten Werten befuellt
			erzeugeNeuenX.setString(0, x);
			erzeugeNeuenX.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public BeispielTyp ladeY() {

		/**
		 * Entsprechendes SQL
		 */

		return new BeispielTyp("Halloooo Welt!");
	}

	public void erhoeheZUmEins(String z) {
		/**
		 * Ruhig Viele Methoden und verschiedene Klassen!
		 */
	}
}

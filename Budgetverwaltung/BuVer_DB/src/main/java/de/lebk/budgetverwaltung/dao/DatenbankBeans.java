package de.lebk.budgetverwaltung.dao;

import java.sql.Connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DatenbankBeans {

	
	@Bean
	public Connection connection() {
		//TODO: Max: hier musst du dafuer sorgen, dass eine Verbindung zur Datenbank fuer das Projekt bereitgestellt wird
		return null;
	}
}

package de.lebk.budgetverwaltung.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Alle Instanzen, die ihr hier als "Beans" definiert, werden von Spring verwaltet und
 * an den benoetigten Stellen in allen Projekten eingesetzt 
 */
@Configuration
public class ServiceBeans {

	@Bean
	public BeispielService beispielService() {
		return new BeispielService();
	}
	
}

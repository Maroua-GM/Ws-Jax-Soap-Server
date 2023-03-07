package fr.doranco.jaxws.main;

import javax.xml.ws.Endpoint;

import fr.doranco.jaxws.CoursService;
import fr.doranco.jaxws.EtudiantService;

public class EtudiantWebServicePublisher {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			System.out.println("Publication du service web 'EtudiantService' et 'CoursService' en cours...");
			Endpoint.publish("http://localhost:9991/ws/etudiant-service", new EtudiantService());
			Endpoint.publish("http://localhost:9991/ws/cours-service", new CoursService());
			System.out.println("Web service 'EtudiantService' && 'CoursService'publié avec succés");
		} catch (Exception e) {
			System.err.println("ERROR: web service non publié");
			System.out.println(e.getMessage());
		}
	}

}

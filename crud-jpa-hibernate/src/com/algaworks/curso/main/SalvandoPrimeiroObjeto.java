package com.algaworks.curso.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class SalvandoPrimeiroObjeto {


	public static void main(String[] args) throws ParseException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = dateFormat.parse("22-12-1990");
		
		
		
				
		Cliente cliente = new Cliente();
		cliente.setNome("  Antonia");
		cliente.setIdade(36);
		cliente.setSexo("F");
		cliente.setProfissao("Copeira");
		cliente.setDataNascimento(date);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		System.out.println("Cliente Salvo com Sucesso!");
		
	}

}

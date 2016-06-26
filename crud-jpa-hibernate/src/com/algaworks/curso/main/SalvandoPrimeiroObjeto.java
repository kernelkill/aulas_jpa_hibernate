package com.algaworks.curso.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class SalvandoPrimeiroObjeto {


	public static void main(String[] args) throws ParseException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						
		Cliente cliente = new Cliente();
		cliente.setNome("Manuel Tiao");
		cliente.setIdade(19);
		cliente.setSexo("F");
		cliente.setProfissao("PO");
		cliente.setDataNascimento( dateFormat.parse("10-07-1989"));
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		System.out.println("Cliente Salvo com Sucesso!");
		
	}

}

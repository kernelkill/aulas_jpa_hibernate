package com.algaworks.curso.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class ConsultaComJPQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		List<Cliente> clientes = em.createQuery("from Cliente", Cliente.class)
				.getResultList();
		for (Cliente cliente : clientes) {
			System.out.println("Codigo: " + cliente.getCodigo());
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Idade: " + cliente.getIdade());
			System.out.println("Profissao: " + cliente.getProfissao());
			System.out.println("-----------------------------------------------------");
		}
	}
}

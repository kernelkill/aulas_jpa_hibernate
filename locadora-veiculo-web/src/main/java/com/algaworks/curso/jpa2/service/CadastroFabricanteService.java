package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;

public class CadastroFabricanteService implements Serializable{
	
	@Inject
	private FabricanteDAO fabricanteDAO;
	
	public void salvar(Fabricante fabricante) throws NegocioException{
		
		if (fabricante.getNome() == null || fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O nome do fabricante é obrigatorio!");
		}
		
		this.fabricanteDAO.salvar(fabricante);
	}

}

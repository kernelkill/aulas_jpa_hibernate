package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class FabricanteDAO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4658564341058289356L;

	@Inject
	private EntityManager em;

	public void salvar(Fabricante fabricante) {
		em.merge(fabricante);
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return em.createQuery("from Fabricante").getResultList();
	}

	@Transactional
	public void excluir(Fabricante fabricanteSelecionado) throws NegocioException {
		Fabricante fabricantetemp = em.find(Fabricante.class, fabricanteSelecionado.getCodigo());
		em.remove(fabricantetemp);
		em.flush();
	}

	public Fabricante buscarPeloCodigo(Long codigo) {

		return em.find(Fabricante.class, codigo);

	}
}

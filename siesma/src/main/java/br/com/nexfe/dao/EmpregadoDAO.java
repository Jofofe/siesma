package br.com.nexfe.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.Empregado;

public class EmpregadoDAO extends DaoImpl<Empregado> {
	
	public List<Empregado> listarTodosSemDistincao() {
		TypedQuery<Empregado> query = em.createNamedQuery("Empregado.selectAllNoDistinction", Empregado.class);
		return query.getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Empregado> listarProfessores() {
		Query query = em.createNamedQuery("Empregado.listarProfessores", Empregado.class);
		return query.getResultList(); 
	}
	
}

package br.com.nexfe.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.Matricula;

public class MatriculaDAO extends DaoImpl<Matricula> {
	
	public List<Matricula> listarTodosSemDistincao() {
		TypedQuery<Matricula> query = em.createNamedQuery("Matricula.selectAllNoDistinction", Matricula.class);
		return query.getResultList(); 
	}

}

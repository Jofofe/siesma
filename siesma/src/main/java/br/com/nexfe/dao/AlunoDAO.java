package br.com.nexfe.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.Aluno;

public class AlunoDAO extends DaoImpl<Aluno> {
	
	public List<Aluno> listarTodosSemDistincao() {
		TypedQuery<Aluno> query = em.createNamedQuery("Aluno.selectAllNoDistinction", Aluno.class);
		return query.getResultList(); 
	}

}

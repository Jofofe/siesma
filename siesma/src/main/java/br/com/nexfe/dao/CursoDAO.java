package br.com.nexfe.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.Curso;

public class CursoDAO extends DaoImpl<Curso>{
	
	public List<Curso> listarTodosSemDistincao() {
		TypedQuery<Curso> query = em.createNamedQuery("Curso.selectAllNoDistinction", Curso.class);
		return query.getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> listarCursosMatriculados(Long idAluno) {
		Query query = em.createNamedQuery("Curso.selectCursosMatriculados", Curso.class);
		query.setParameter("idAluno", idAluno);
		return query.getResultList(); 
	}
	
}

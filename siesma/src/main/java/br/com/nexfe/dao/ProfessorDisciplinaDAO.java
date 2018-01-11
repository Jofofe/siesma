package br.com.nexfe.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.ProfessorDisciplina;

public class ProfessorDisciplinaDAO extends DaoImpl<ProfessorDisciplina>{
	
	@SuppressWarnings("unchecked")
	public List<ProfessorDisciplina> listarDataAtual() {
		Query query = em.createNamedQuery("ProfessorDisciplina.selectAllDate", ProfessorDisciplina.class);
		query.setParameter("dataAtual", new Date());
		return query.getResultList(); 
	}

}

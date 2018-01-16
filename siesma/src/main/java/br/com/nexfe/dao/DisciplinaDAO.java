package br.com.nexfe.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.Disciplina;

public class DisciplinaDAO extends DaoImpl<Disciplina>{
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> listarDataAtual() {
		Query query = em.createNamedQuery("Disciplina.selectAllDate", Disciplina.class);
		query.setParameter("dataAtual", new Date());
		return query.getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> listarDisciplinasMagistradas(Long idEmpregado) {
		Query query = em.createNamedQuery("Disciplina.selectDisciplinasMagistradas", Disciplina.class);
		query.setParameter("idEmpregado", idEmpregado);
		return query.getResultList(); 
	}

}

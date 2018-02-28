package br.com.nexfe.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.Modulo;

public class ModuloDAO extends DaoImpl<Modulo>{
	
	@SuppressWarnings("unchecked")
	public List<Modulo> listarDataAtual() {
		Query query = em.createNamedQuery("Modulo.selectAllDate", Modulo.class);
		query.setParameter("dataAtual", new Date());
		return query.getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Modulo> listarModulosCurso(Long id) {
		Query query = em.createNamedQuery("Modulo.selectModulosCurso", Modulo.class);
		query.setParameter("idCurso", id);
		query.setParameter("dataAtual", new Date());
		return query.getResultList();
	}
	
}

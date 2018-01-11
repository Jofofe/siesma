package br.com.nexfe.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.Desconto;

public class DescontoDAO extends DaoImpl<Desconto>{
	
	@SuppressWarnings("unchecked")
	public List<Desconto> listarDataAtual() {
		Query query = em.createNamedQuery("Desconto.selectAllDate", Desconto.class);
		query.setParameter("dataAtual", new Date());
		return query.getResultList(); 
	}

}

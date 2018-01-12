package br.com.nexfe.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.LancamentoComercial;

public class LancamentoComercialDAO extends DaoImpl<LancamentoComercial>{
	
	@SuppressWarnings("unchecked")
	public List<LancamentoComercial> listarDataAtual() {
		Query query = em.createNamedQuery("LancamentoComercial.selectAllDate", LancamentoComercial.class);
		query.setParameter("dataAtual", new Date());
		return query.getResultList(); 
	}

}

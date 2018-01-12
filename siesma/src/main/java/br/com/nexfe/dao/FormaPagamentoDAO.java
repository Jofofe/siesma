package br.com.nexfe.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.FormaPagamento;

public class FormaPagamentoDAO extends DaoImpl<FormaPagamento>{
	
	@SuppressWarnings("unchecked")
	public List<FormaPagamento> listarDataAtual() {
		Query query = em.createNamedQuery("FormaPagamento.selectAllDate", FormaPagamento.class);
		query.setParameter("dataAtual", new Date());
		return query.getResultList(); 
	}

}

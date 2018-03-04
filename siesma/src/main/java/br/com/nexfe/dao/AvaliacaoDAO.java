package br.com.nexfe.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.Avaliacao;

public class AvaliacaoDAO extends DaoImpl<Avaliacao> {
	
	@SuppressWarnings("unchecked")
	public List<Avaliacao> listarDataAtual() {
		Query query = em.createNamedQuery("Avaliacao.selectAllDate", Avaliacao.class);
		query.setParameter("dataAtual", new Date());
		return query.getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<Avaliacao> listarAvaliacoesComNota() {
		Query query = em.createNamedQuery("Avaliacao.selectAllComNota", Avaliacao.class);
		query.setParameter("dataAtual", new Date());
		return query.getResultList(); 
	}

}

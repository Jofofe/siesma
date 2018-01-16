package br.com.nexfe.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.TipoLancamento;

public class TipoLancamentoDAO extends DaoImpl<TipoLancamento> {
	
	public List<TipoLancamento> listarTodosSemDistincao() {
		TypedQuery<TipoLancamento> query = em.createNamedQuery("TipoLancamento.selectAllNoDistinction", TipoLancamento.class);
		return query.getResultList(); 
	}

}

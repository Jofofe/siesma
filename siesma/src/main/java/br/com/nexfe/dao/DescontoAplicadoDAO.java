package br.com.nexfe.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.DescontoAplicado;

public class DescontoAplicadoDAO extends DaoImpl<DescontoAplicado> {
	
	@SuppressWarnings("unchecked")
	public List<DescontoAplicado> listarDataAtual() {
		Query query = em.createNamedQuery("DescontoAplicado.selectAllDate", DescontoAplicado.class);
		query.setParameter("dataAtual", new Date());
		return query.getResultList(); 
	}

}

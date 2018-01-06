package br.com.nexfe.dao;

import javax.persistence.Query;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.NivelAcesso;

public class NivelAcessoDAO extends DaoImpl<NivelAcesso>{
	
	public NivelAcesso retornaNivelAcesso(Integer id) {
        String hql = "Select n from NivelAcesso n where n.idNivelAcesso = " + id;
        Query query = em.createQuery(hql);
        return (NivelAcesso) query.getSingleResult();
    }

}

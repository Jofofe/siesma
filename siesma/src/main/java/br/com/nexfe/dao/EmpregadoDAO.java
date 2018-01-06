package br.com.nexfe.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.Empregado;

public class EmpregadoDAO extends DaoImpl<Empregado> {
	
	public static final String CODIGO_ADMINISTRATIVO = "1";
	public static final String CODIGO_PROFESSOR = "2";
	
	public List<Empregado> listarProfessores() {
        String hql = "Select e from Empregado e where e.funcao.idFuncao = " + CODIGO_PROFESSOR;
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

}

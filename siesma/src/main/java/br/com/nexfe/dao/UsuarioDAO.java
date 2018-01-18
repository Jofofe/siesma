package br.com.nexfe.dao;

import javax.persistence.Query;

import br.com.nexfe.dao.generic.DaoImpl;
import br.com.nexfe.entidades.Usuario;

public class UsuarioDAO extends DaoImpl<Usuario> {
	
	public Usuario login(String email, String senha) {
		try {
			Query query = em.createNamedQuery("Usuario.selectLogin", Usuario.class);
			query.setParameter("email", email);
			query.setParameter("senha",senha);
			return (Usuario) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}

package br.com.nexfe.dao.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.nexfe.fabrica.JPAUtil;

public abstract class DaoImpl<E> implements Dao<E> {
	
	protected EntityManager em = JPAUtil.getEntityManager();
	
	@Override
	public void salvar(E entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void alterar(E entidade) {
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();
	}
	
	/*@Override
	public E alterar(ENTIDADE entidade) {
		em.getTransaction().begin();
		ENTIDADE alterada = em.merge(entidade);
		em.getTransaction().commit();
		return alterada;
	}*/

	@Override
	public void excluir(E entidade) {
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
		em.close();
	}
	@Override
	public E buscar(Object id, Class<E> classe) {
		return em.find(classe, id);
	}
	
	@Override
    public List<E> listar(Class<E> classe) {
        String hql="Select e from "+classe.getSimpleName() +" e";
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

}

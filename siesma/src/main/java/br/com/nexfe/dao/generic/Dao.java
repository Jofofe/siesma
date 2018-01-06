package br.com.nexfe.dao.generic;

import java.util.List;


public interface Dao <E> {
	
	void salvar(E entidade);
	
	void alterar(E entidade);
	
	//E alterar(E entidade);
	
	void excluir(E entidade);
	
	E buscar(Object id, Class<E> classe);
	
	List<E> listar(Class<E> classe);
}

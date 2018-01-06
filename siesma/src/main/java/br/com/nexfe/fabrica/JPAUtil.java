package br.com.nexfe.fabrica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final String UNIT_NAME = "SIESMA";
	private static final EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory(UNIT_NAME);
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}

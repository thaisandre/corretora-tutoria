package br.com.corretora.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("corretora");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static void close() {
		factory.close();
	}
}

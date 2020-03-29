package br.com.vivo.actionrecorder.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");

	public EntityManager getFinancasEntityManagerFactory() {
		return entityManagerFactory.createEntityManager();
	}
}
package progettoejb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDao {
	
	@PersistenceContext(unitName="persistenceUnit1")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}
}

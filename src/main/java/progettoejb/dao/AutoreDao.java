package progettoejb.dao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;

import progettoejb.entity.Autore;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AutoreDao extends GenericDao{
	
	public void save(Autore autore) {
		getEm().persist(autore);
	}
	
	public Autore getById(int id) {
		return getEm().find(Autore.class, id);
	}
	
	public void delete(Autore autore) {
		EntityManager em = getEm();
		em.remove(em.contains(autore) ? autore : em.merge(autore));
		//em.remove(em.contains(entity) ? entity : em.merge(entity));
	}
	
	public void updateNome(int id, String nuovoNome) {
		Autore autore = getById(id);
		autore.setNome(nuovoNome);
		getEm().merge(autore);
	}

}

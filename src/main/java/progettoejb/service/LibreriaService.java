package progettoejb.service;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import progettoejb.dao.AutoreDao;
import progettoejb.dto.AutoreDto;
import progettoejb.entity.Autore;
import progettoejb.entity.Libro;
import progettoejb.mapper.MapperAutore;

@TransactionManagement(TransactionManagementType.CONTAINER)
public class LibreriaService implements LibreriaServiceInterface {
	
	//@EJB -> 
	//@Resource -> iniettare una risosrsa esterna (cache, connessioni) che non è un ejb definito nell'app (preso da file standalone.xml
	@Inject
	private AutoreDao autoreDao;
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void test(List<AutoreDto> listaAutori) {
		for(AutoreDto a : listaAutori) {
			Autore autore = MapperAutore.INSTANCE.map(a);
			autoreDao.save(autore);
		}
	}
	
	/*@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void test2() {
		autoreDao.getById(0); //è libroDao che ha tutti i metodi requires_new
		// altri metodi dao
	}*/
	
	@Override
	public String createHelloAutore(int id) {
		String str = "Hello " + autoreDao.getById(id).getNome(); 
		return str;
	}
	
	
	public AutoreDto getAutoreLibro(Libro libro) {
		AutoreDto autore = MapperAutore.INSTANCE.map(libro.getAutore());
		return autore;
	}
	
	public AutoreDto getById(int id) {
		AutoreDto autoreDto = MapperAutore.INSTANCE.map(autoreDao.getById(id));
		return autoreDto;
	}
	
	public void createAutore(AutoreDto nuovoAutore) {
		Autore autore = MapperAutore.INSTANCE.map(nuovoAutore);
		autoreDao.save(autore);
	}
	
	public void deleteAutore(AutoreDto autoreToDelete) {
		Autore autore = MapperAutore.INSTANCE.map(autoreToDelete);
		autoreDao.delete(autore);
	}
	
	public void updateNomeAutore(int id, String nome) {
		//autoreDao.updateNome(id, nome);
		Autore autore = autoreDao.getById(id);
		autore.setNome(nome);
	}
	

}

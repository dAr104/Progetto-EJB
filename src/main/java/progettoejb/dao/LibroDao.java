package progettoejb.dao;

import progettoejb.entity.Libro;

public class LibroDao extends GenericDao{
	
	public void save(Libro libro) {
		getEm().persist(libro);
	}
	

	public Libro getLibro(String isbn) {
		return getEm().find(Libro.class, isbn);
	}

}

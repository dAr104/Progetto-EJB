package progettoejb.service;

import javax.ejb.Local;
import javax.ejb.Stateless;

import progettoejb.dto.AutoreDto;

@Local
@Stateless
public interface LibreriaServiceInterface {
	
	public String createHelloAutore(int id);

}

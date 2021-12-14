package progettoejb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import progettoejb.dto.AutoreDto;
import progettoejb.entity.Autore;

@Mapper(componentModel = "cdi")
public interface MapperAutore {


	MapperAutore INSTANCE = Mappers.getMapper(MapperAutore.class);

	//@Mappings({ 
	//   @Mapping(target = "creationUserId", ignore = true), 
	//   @Mapping(target = "lastUserId", ignore = true),
	//	@Mapping(target = "id", source = "identifier"), @Mapping(target = "managedInSlo", ignore = true) })
	AutoreDto map(Autore source);
	
	Autore map(AutoreDto source);
	

}

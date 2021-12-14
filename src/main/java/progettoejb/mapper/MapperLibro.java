package progettoejb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import progettoejb.dto.LibroDto;
import progettoejb.entity.Libro;

@Mapper(componentModel = "cdi")
public interface MapperLibro {


	MapperLibro INSTANCE = Mappers.getMapper(MapperLibro.class);

	//@Mappings({ 
	//   @Mapping(target = "creationUserId", ignore = true), 
	//   @Mapping(target = "lastUserId", ignore = true),
	//	@Mapping(target = "id", source = "identifier"), @Mapping(target = "managedInSlo", ignore = true) })
	LibroDto map(Libro source);
}

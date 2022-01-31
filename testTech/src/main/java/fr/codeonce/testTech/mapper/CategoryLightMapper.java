package fr.codeonce.testTech.mapper;

import org.mapstruct.Mapper;

import fr.codeonce.testTech.DTO.CategoryLightDTO;
import fr.codeonce.testTech.model.CategoryLight;

@Mapper(componentModel = "spring")
public interface CategoryLightMapper {
	CategoryLight toBO(CategoryLightDTO categoryLightDTO);

	CategoryLightDTO toDTO(CategoryLight categoryLight);
}

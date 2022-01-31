package fr.codeonce.testTech.mapper;

import org.mapstruct.Mapper;

import fr.codeonce.testTech.DTO.ProductLightDTO;
import fr.codeonce.testTech.model.ProductLight;

@Mapper(componentModel = "spring")
public interface ProductLightMapper {

	ProductLight toBO(ProductLightDTO productLightDTO);

	ProductLightDTO toDTO(ProductLight productLight);
}

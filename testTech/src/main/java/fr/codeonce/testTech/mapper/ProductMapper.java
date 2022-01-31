package fr.codeonce.testTech.mapper;

import org.mapstruct.Mapper;

import fr.codeonce.testTech.DTO.CategoryLightDTO;
import fr.codeonce.testTech.DTO.ProductDTO;
import fr.codeonce.testTech.model.CategoryLight;
import fr.codeonce.testTech.model.Product;
import fr.codeonce.testTech.model.ProductLight;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	Product toBO(ProductDTO productDTO);

	ProductDTO toDTO(Product product);

	ProductLight toLight(Product product);

	CategoryLight toBO(CategoryLightDTO categoryLightDTO);

	CategoryLightDTO toDTO(CategoryLight categoryLight);
}

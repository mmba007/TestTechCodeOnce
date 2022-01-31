package fr.codeonce.testTech.mapper;

import org.mapstruct.Mapper;

import fr.codeonce.testTech.DTO.CategoryDTO;
import fr.codeonce.testTech.DTO.ProductLightDTO;
import fr.codeonce.testTech.model.Category;
import fr.codeonce.testTech.model.ProductLight;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	Category toBO(CategoryDTO categoryDTO);

	CategoryDTO toDTO(Category category);

	ProductLight toBO(ProductLightDTO productLightDTO);

	ProductLightDTO toDTO(ProductLight productLight);
}

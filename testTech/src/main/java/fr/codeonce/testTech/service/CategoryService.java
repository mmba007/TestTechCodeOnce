package fr.codeonce.testTech.service;

import java.sql.SQLException;
import java.util.List;

import fr.codeonce.testTech.DTO.CategoryDTO;
import fr.codeonce.testTech.DTO.ProductDTO;

public interface CategoryService {

	public String createCategory(CategoryDTO categoryDTO) throws SQLException;
	
	public List<CategoryDTO> findAll();
	
	public void deleteAll();
}

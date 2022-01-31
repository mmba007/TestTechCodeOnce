package fr.codeonce.testTech.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import fr.codeonce.testTech.DTO.ProductDTO;
import fr.codeonce.testTech.DTO.ProductLightDTO;
import fr.codeonce.testTech.model.Product;

public interface ProductService {

	public String createProduct(ProductDTO productDTO) throws SQLException, Exception;

	public ProductDTO getProductById(String productId) throws SQLException, Exception;

	public List<ProductLightDTO> searchProductsByCategoryName(String categoryName);

	public List<ProductLightDTO> searchAvailableProductsByCategoryName(int skip, int limit,String categoryName);

	public List<ProductDTO> findAll();

	public void deleteAll();
}
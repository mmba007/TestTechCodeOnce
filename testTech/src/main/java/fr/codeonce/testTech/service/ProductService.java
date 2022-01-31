package fr.codeonce.testTech.service;

import java.sql.SQLException;
import java.util.List;

import fr.codeonce.testTech.DTO.ProductDTO;
import fr.codeonce.testTech.DTO.ProductLightDTO;

public interface ProductService {

	public String createProduct(ProductDTO productDTO) throws SQLException, Exception;

	public ProductDTO getProductById(String productId) throws SQLException, Exception;

	public List<ProductLightDTO> searchProductsByCategoryName(String categoryName, int skip, int limit);

	public List<ProductLightDTO> searchAvailableProductsByCategoryName(int skip, int limit, String categoryName);

	public List<ProductDTO> findAll();

	public void deleteAll();

	public void deleteOneProduct(String id);
}
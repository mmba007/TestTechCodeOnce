package fr.codeonce.testTech.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.codeonce.testTech.DTO.CategoryDTO;
import fr.codeonce.testTech.DTO.ProductDTO;
import fr.codeonce.testTech.DTO.ProductLightDTO;
import fr.codeonce.testTech.mapper.CategoryMapper;
import fr.codeonce.testTech.mapper.ProductMapper;
import fr.codeonce.testTech.service.CategoryService;
import fr.codeonce.testTech.service.ProductService;

@RestController
@RequestMapping("/api")
//@CrossOrigin("http://front:80") // for production environment
@CrossOrigin("http://localhost:4200")
public class ProductsController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@Autowired
	ProductMapper productMapper;

	@Autowired
	CategoryMapper categoryMapper;

	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/products/{productId}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable("productId") String productId) throws Exception {
		return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
	}

	@GetMapping("/categories")
	public ResponseEntity<List<CategoryDTO>> getAllCategories() {
		return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/products/category/{categoryName}")
	public ResponseEntity<List<ProductLightDTO>> getProductsByCategory(
			@PathVariable("categoryName") String categoryName,
			@RequestParam(name = "skip", required = false, defaultValue = "0") int skip,
			@RequestParam(name = "limit", required = false, defaultValue = "16") Integer limit) {
		return new ResponseEntity<>(productService.searchProductsByCategoryName(categoryName, skip, limit),
				HttpStatus.OK);
	}

	@GetMapping("/products-in-stock/category/{categoryName}")
	public ResponseEntity<List<ProductLightDTO>> getAvailableProductsByCategory(
			@PathVariable("categoryName") String categoryName,
			@RequestParam(name = "skip", required = false, defaultValue = "0") int skip,
			@RequestParam(name = "limit", required = false, defaultValue = "16") Integer limit) {
		return new ResponseEntity<>(productService.searchAvailableProductsByCategoryName(skip, limit, categoryName),
				HttpStatus.OK);
	}

	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO) throws Exception {
		return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.OK);
	}

	@PostMapping("/categories")
	public ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO) throws SQLException {
		return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.OK);
	}

	@DeleteMapping("/products/delete/{productId}")
	public ResponseEntity<Void> deleteProductById(@PathVariable("productId") String productId) {
		productService.deleteOneProduct(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/products/delete")
	public ResponseEntity<Void> deleteAllProducts() {
		productService.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/categories/delete/{categoryId}")
	public ResponseEntity<Void> deleteCategoryById(@PathVariable("categoryId") String categoryId) {
		categoryService.deleteOneCateogory(categoryId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/categories/delete")
	public ResponseEntity<Object> deleteAllCategories() {
		categoryService.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

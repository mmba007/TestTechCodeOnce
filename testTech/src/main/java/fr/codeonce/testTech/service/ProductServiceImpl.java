package fr.codeonce.testTech.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.codeonce.testTech.DTO.ProductDTO;
import fr.codeonce.testTech.DTO.ProductLightDTO;
import fr.codeonce.testTech.exception.BadRequestException;
import fr.codeonce.testTech.exception.RecordNotFoundException;
import fr.codeonce.testTech.mapper.ProductLightMapper;
import fr.codeonce.testTech.mapper.ProductMapper;
import fr.codeonce.testTech.model.Category;
import fr.codeonce.testTech.model.CategoryLight;
import fr.codeonce.testTech.model.Product;
import fr.codeonce.testTech.repository.CategoryRepo;
import fr.codeonce.testTech.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepo productRepo;

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	ProductMapper productMapper;

	@Autowired
	ProductLightMapper productLightMapper;

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public String createProduct(ProductDTO productDTO) throws Exception {
		log.info("Creating new product ...");
		Product savedProduct = productRepo.save(productMapper.toBO(productDTO));
		CategoryLight productCateg = savedProduct.getCategory();
		if (savedProduct != null && productCateg != null) {
			categoryRepo.findById(productCateg.getCategoryId()).map(pc -> {
				pc.getProducts().add(productMapper.toLight(savedProduct));
				categoryRepo.save(pc);
				return pc;
			}).orElseThrow(() -> new BadRequestException("You should provide a category !"));
			log.info("Product with id " + savedProduct.getProductId() + " created successfully");
			return savedProduct.getProductId();
		}
		log.error("Error while creating product");
		throw new SQLException("Coudln't create product !!");
	}

	@Override
	public ProductDTO getProductById(String productId) throws Exception {
		log.info("Getting product with id " + productId + " ...");
		return productRepo.findById(productId).map(p -> productMapper.toDTO(p))
				.orElseThrow(() -> new RecordNotFoundException("Product with id " + productId + " not found!!"));
	}

	@Override
	public List<ProductLightDTO> searchProductsByCategoryName(String categoryName, int skip, int limit) {
		List<ProductLightDTO> result = new ArrayList<ProductLightDTO>();
		Category categ = categoryRepo.findByName(skip, limit, categoryName).get();
		log.info("Searching for products under category " + categ.getName() + " ...");
		if (categ != null) {
			result = categ.getProducts().stream().map(pl -> productLightMapper.toDTO(pl)).collect(Collectors.toList());
		}
		return result;
	}

	@Override
	public List<ProductLightDTO> searchAvailableProductsByCategoryName(int skip, int limit, String categoryName) {
		List<ProductLightDTO> result = new ArrayList<ProductLightDTO>();
		Category categ = categoryRepo.findByName(skip, limit, categoryName).get();
		log.info("Searching for products under category " + categ.getName() + " ...");
		if (categ != null) {
			result = categ.getProducts().stream().filter(pl -> pl.getQuantity() > 0)
					.map(pl -> productLightMapper.toDTO(pl)).collect(Collectors.toList());
		}
		return result;
	}

	@Override
	public List<ProductDTO> findAll() {
		log.info("Fetching all products ...");
		return productRepo.findAll().stream().map(p -> productMapper.toDTO(p)).collect(Collectors.toList());
	}

	@Override
	public void deleteAll() {
		log.info("Deleting all products ...");
		productRepo.deleteAll();
	}

	@Override
	public void deleteOneProduct(String id) {
		log.info("Deleting product with id " + id + " ...");
		productRepo.deleteById(id);
	}

}

package fr.codeonce.testTech.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fr.codeonce.testTech.DTO.ProductDTO;
import fr.codeonce.testTech.model.Category;
import fr.codeonce.testTech.repository.CategoryRepo;
import fr.codeonce.testTech.repository.ProductRepo;
import fr.codeonce.testTech.service.CategoryService;
import fr.codeonce.testTech.service.ProductService;

@Component
public class DummyLoader implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(DummyLoader.class);

	@Autowired
	ProductRepo productRepo;

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Charging database ...");

		Category electronics = new Category("Electronics");
		Category toys = new Category("Toys");
		Category kitchen = new Category("Kitchen");

		categoryRepo.save(electronics);
		categoryRepo.save(toys);
		categoryRepo.save(kitchen);

		ProductDTO electronic1 = new ProductDTO("prod1", "TV", "", 500.7, electronics.getCategoryId(),
				electronics.getName(), 10, "url1");
		ProductDTO electronic2 = new ProductDTO("prod2", "Camera", "", 189.7, electronics.getCategoryId(),
				electronics.getName(), 15, "url1");
		ProductDTO electronic3 = new ProductDTO("prod3", "PC", "", 1400.7, electronics.getCategoryId(),
				electronics.getName(), 20, "url1");

		ProductDTO toys1 = new ProductDTO("prod4", "Kids Toy", "", 77.0, toys.getCategoryId(), toys.getName(), 11,
				"url1");
		ProductDTO toys2 = new ProductDTO("prod5", "Teddy Bear", "", 34.0, toys.getCategoryId(), toys.getName(), 5,
				"url1");
		ProductDTO toys3 = new ProductDTO("prod6", "Scrabble", "", 24.0, toys.getCategoryId(), toys.getName(), 1,
				"url1");

		ProductDTO kitchen1 = new ProductDTO("prod7", "Knive", "", 4.0, kitchen.getCategoryId(), kitchen.getName(), 111,
				"url1");
		ProductDTO kitchen2 = new ProductDTO("prod8", "Spoon", "", 1.05, kitchen.getCategoryId(), kitchen.getName(), 41,
				"url1");
		ProductDTO kitchen3 = new ProductDTO("prod9", "Plate", "", 6.9, kitchen.getCategoryId(), kitchen.getName(), 30,
				"url1");

		List<ProductDTO> products = new ArrayList<ProductDTO>(Arrays.asList(electronic1, electronic2, electronic3,
				toys1, toys2, toys3, kitchen1, kitchen2, kitchen3));

		for (ProductDTO p : products) {
			productService.createProduct(p);
		}
	}
}
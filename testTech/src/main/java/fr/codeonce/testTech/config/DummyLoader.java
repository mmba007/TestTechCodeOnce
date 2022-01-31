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
		LOG.info("Loading database with dummy values ...");

		// deleting existing recors
		productRepo.deleteAll();
		categoryRepo.deleteAll();

		Category electronics = new Category("Electronics");
		Category toys = new Category("Toys");
		Category kitchen = new Category("Kitchen");

		categoryRepo.save(electronics);
		categoryRepo.save(toys);
		categoryRepo.save(kitchen);

		ProductDTO electronic1 = new ProductDTO("prod1", "TV LG", "High quality TV LG", 500.7,
				electronics.getCategoryId(), electronics.getName(), 0,
				"https://images.samsung.com/is/image/samsung/africa-fr-n5000-series-ua43n5000auxke-frontblack-227264789?$720_576_PNG$");
		ProductDTO electronic2 = new ProductDTO("prod2", "Sony Camera", "Sony Ultra HD camera", 189.7,
				electronics.getCategoryId(), electronics.getName(), 15,
				"https://media.istockphoto.com/photos/black-digital-slr-camera-in-a-white-background-picture-id185278433?k=20&m=185278433&s=612x612&w=0&h=_JuLqy0HIaC3dq9V0x2xhh_VpUsHMSjAmZJmWMTBK3c=");
		ProductDTO electronic3 = new ProductDTO("prod3", "Gaming PC", "Gaming desktop PC", 1400.7,
				electronics.getCategoryId(), electronics.getName(), 20,
				"https://image.made-in-china.com/2f0j00dDWfNGuhgikU/Desktop-Computer-Price-Office-PC-Gamer-Windows10-Low-Price-Personal.jpg");

		ProductDTO toys1 = new ProductDTO("prod4", "Kids Toy", "A car Toy", 77.0, toys.getCategoryId(), toys.getName(),
				11, "https://5.imimg.com/data5/WX/SU/MY-63727127/kids-toys-500x500.jpg");
		ProductDTO toys2 = new ProductDTO("prod5", "Teddy Bear", "Brown Teddy Bear", 34.0, toys.getCategoryId(),
				toys.getName(), 5,
				"https://www.ubuy.tn/productimg/?image=aHR0cHM6Ly9tLm1lZGlhLWFtYXpvbi5jb20vaW1hZ2VzL0kvNzFxVlZVQUlOTkwuX0FDX1NMMTAwMF8uanBn.jpg");
		ProductDTO toys3 = new ProductDTO("prod6", "Scrabble Board", "Scrabble board", 24.0, toys.getCategoryId(),
				toys.getName(), 1, "https://m.media-amazon.com/images/I/81OjLGNO5VL._AC_SL1500_.jpg");

		ProductDTO kitchen1 = new ProductDTO("prod7", "Knive", "Sharp kitchen knive", 4.0, kitchen.getCategoryId(),
				kitchen.getName(), 111, "https://m.media-amazon.com/images/I/21r60GoUfNL._SX385_.jpg");
		ProductDTO kitchen2 = new ProductDTO("prod8", "Spoon", "Silver Spoon", 1.05, kitchen.getCategoryId(),
				kitchen.getName(), 41,
				"https://5.imimg.com/data5/BH/AQ/MY-14808007/stainless-steel-kitchen-spoon-500x500.jpg");
		ProductDTO kitchen3 = new ProductDTO("prod9", "Plate", "High quality kitchen plates", 6.9,
				kitchen.getCategoryId(), kitchen.getName(), 30,
				"https://advice.diy-kitchens.com/wp-content/uploads/2015/09/dinner-plates.jpg");

		List<ProductDTO> products = new ArrayList<ProductDTO>(Arrays.asList(electronic1, electronic2, electronic3,
				toys1, toys2, toys3, kitchen1, kitchen2, kitchen3));

		for (ProductDTO p : products) {
			productService.createProduct(p);
		}
	}
}
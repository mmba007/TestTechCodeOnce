package fr.codeonce.testTech.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import fr.codeonce.testTech.DTO.ProductDTO;
import fr.codeonce.testTech.DTO.ProductLightDTO;
import fr.codeonce.testTech.mapper.CategoryLightMapper;
import fr.codeonce.testTech.mapper.CategoryMapper;
import fr.codeonce.testTech.mapper.ProductLightMapper;
import fr.codeonce.testTech.mapper.ProductMapper;
import fr.codeonce.testTech.model.Category;
import fr.codeonce.testTech.model.Product;
import fr.codeonce.testTech.model.ProductLight;
import fr.codeonce.testTech.repository.CategoryRepo;
import fr.codeonce.testTech.repository.ProductRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
public class ProductServiceTest {

	@MockBean
	ProductRepo productRepo;
	@MockBean
	CategoryRepo categoryRepo;
	@Autowired
	ProductServiceImpl productService;
	@InjectMocks
	CategoryServiceImpl categoryService;
	@Autowired
	CategoryMapper categoryMapper;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	ProductLightMapper productLightMapper;
	@Autowired
	CategoryLightMapper categoryLightMapper;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllProducts() {
		List<Product> products = new ArrayList<>();
		products.add(new Product("111", "prod1", "", 10.5, "categ1", 1, ""));
		products.add(new Product("222", "prod2", "", 17.5, "categ2", 1, ""));
		products.add(new Product("333", "prod3", "", 18.5, "categ3", 1, ""));
		when(productRepo.findAll()).thenReturn(products);
		List<ProductDTO> result = productService.findAll();
		assertEquals(3, result.size());
	}

	@Test
	public void testGetProductById() throws Exception {
		Product prod = new Product("111", "prod1", "", 10.5, "categ1", 1, "url");
		when(productRepo.findById("111")).thenReturn(Optional.of(prod));
		ProductDTO result = productService.getProductById("111");
		assertEquals("111", result.getProductId());
		assertEquals("prod1", result.getName());
		assertEquals("url", result.getImageURL());
		assertEquals(Integer.valueOf(1), result.getQuantity());
		assertEquals(Double.valueOf(10.5), result.getPrice());
	}

	@Test
	public void testCreateProduct() throws Exception {
		Product prod = new Product("111", "prod1", "", 10.5, "id1", "categ1", 1, "url");
		Category category = new Category("id1", "categ1");
		ProductDTO prodDTO = new ProductDTO("111", "prod1", "", 10.5, "categ1", 1, "url");
		when(productRepo.save(prod)).thenReturn(prod);
		when(categoryRepo.findById(prod.getCategory().getCategoryId())).thenReturn(Optional.of(category));
		String result = productService.createProduct(prodDTO);
		assertEquals("111", result);
	}

	@Test
	public void testSeachProductByCategoryName() throws SQLException {
		List<ProductLight> products = new ArrayList<ProductLight>();
		Category categ = new Category("categ1");
		products.add(new ProductLight("111", "prod1", 10.5, 1, "url1"));
		products.add(new ProductLight("222", "prod2", 14.5, 5, "url2"));
		products.add(new ProductLight("333", "prod3", 19.5, 11, "url3"));
		categ.setProducts(products);
		when(categoryRepo.findByName(0, 3, "categ1")).thenReturn(Optional.of(categ));
		List<ProductLightDTO> result = productService.searchAvailableProductsByCategoryName(0, 3, "categ1");
		assertEquals(3, result.size());
	}

}

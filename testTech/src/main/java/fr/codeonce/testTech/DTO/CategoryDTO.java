package fr.codeonce.testTech.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class CategoryDTO {
	private String categoryId;

	@Min(value = 3)
	private String name;

	@Max(value = 50)
	private String description;

	private List<ProductLightDTO> products = new ArrayList<ProductLightDTO>();

	public CategoryDTO(String categoryName) {
		this.name = categoryName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductLightDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductLightDTO> products) {
		this.products = products;
	}

	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}

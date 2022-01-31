package fr.codeonce.testTech.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("product")
public class Product {
	@Id
	private String productId;

	@Size(min = 3, max = 15)
	private String name;

	@Size(max = 40, message = "Description must not exceed 40 characters")
	private String description;

	@NotNull
	private Double price;

	@NotNull(message = "You must specify product's category")
	private CategoryLight category;

	@Positive(message = "Quantity must be a positive number")
	private Integer quantity;

	@URL
	private String imageURL;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CategoryLight getCategory() {
		return category;
	}

	public void setCategory(CategoryLight category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Product(String productId, @Size(min = 3, max = 15) String name,
			@Size(max = 40, message = "Description must not exceed 40 characters") String description,
			@NotNull Double price, String categId,
			@NotNull(message = "You must specify product's category") String categoryName,
			@Positive(message = "Quantity must be a positive number") Integer quantity, @URL String imageURL) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = new CategoryLight(categId, categoryName);
		this.quantity = quantity;
		this.imageURL = imageURL;
	}

	public Product(String productId, @Size(min = 3, max = 15) String name,
			@Size(max = 40, message = "Description must not exceed 40 characters") String description,
			@NotNull Double price, @NotNull(message = "You must specify product's category") String categoryName,
			@Positive(message = "Quantity must be a positive number") Integer quantity, @URL String imageURL) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = new CategoryLight(categoryName);
		this.quantity = quantity;
		this.imageURL = imageURL;
	}
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product) o;
		return productId.equals(product.productId) && name.equals(product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, name);
	}
}

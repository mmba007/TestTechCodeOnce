package fr.codeonce.testTech.model;

public class ProductLight {

	private String productId;
	private String name;
	private Integer quantity;
	private Double price;
	private String imageURL;

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String id) {
		this.productId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductLight(String productId, String name, Double price, Integer quantity, String imageURL) {
		super();
		this.productId = productId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.imageURL = imageURL;
	}

	public ProductLight() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

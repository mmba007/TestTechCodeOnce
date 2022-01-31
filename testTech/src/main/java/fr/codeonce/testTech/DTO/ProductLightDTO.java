package fr.codeonce.testTech.DTO;

public class ProductLightDTO {
	private String productId;
	private String name;
	private Double price;
	private Integer quantity;
	private String imageURL;

	public ProductLightDTO(String productId, String name, Double price, Integer quantity, String imageURL) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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

	public ProductLightDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

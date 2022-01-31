package fr.codeonce.testTech.DTO;

public class CategoryLightDTO {
	private String categoryId;

	private String name;

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

	public CategoryLightDTO(String name) {
		super();
		this.name = name;
	}

	public CategoryLightDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

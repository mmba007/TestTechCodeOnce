package fr.codeonce.testTech.model;

public class CategoryLight {

	public CategoryLight(String categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

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

	public CategoryLight(String name) {
		super();
		this.name = name;
	}

	public CategoryLight() {
		super();
		// TODO Auto-generated constructor stub
	}

}

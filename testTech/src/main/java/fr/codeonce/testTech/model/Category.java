package fr.codeonce.testTech.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("category")
public class Category {
	@Id
	private String categoryId;

	@Indexed(unique = true)
	@Min(value = 3)
	private String name;

	@Max(value = 50)
	private String description;

	private List<ProductLight> products = new ArrayList<ProductLight>();

	public Category(String name) {
		this.name = name;
	}
	
	

	public Category(String categoryId, @Min(3) String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
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

	public List<ProductLight> getProducts() {
		return products;
	}

	public void setProducts(List<ProductLight> products) {
		this.products = products;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}



	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
